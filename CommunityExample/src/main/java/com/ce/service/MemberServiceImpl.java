package com.ce.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

import com.ce.component.hash.HashHelper;
import com.ce.dao.MemberDAO;
import com.ce.dao.ShopDAO;
import com.ce.dto.BookmarkBoardDTO;
import com.ce.dto.MemberAuthDTO;
import com.ce.dto.MemberDTO;

public class MemberServiceImpl implements MemberService {
	private final int SUCCESS = 1;
	private final int FAIL = -1;
	private static final Logger log = LoggerFactory.getLogger(MemberServiceImpl.class);
	private MemberDAO memberDao;
	private ShopDAO shopDao;
	@Resource(name = "hashHelper")
	private HashHelper hashHelper;
	@Resource(name = "javaMail")
	private JavaMailSender mailSender;

	public void setMemberDao(MemberDAO memberDao) {
		this.memberDao = memberDao;
	}

	public void setShopDao(ShopDAO shopDao) {
		this.shopDao = shopDao;
	}

	public void setHashHelper(HashHelper hashHelper) {
		this.hashHelper = hashHelper;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Async
	@Override
	public int sendMail(MemberDTO memberDto) {
		int result = 0;
		log.debug("sendMail()");
		MimeMessage message = null;
		MimeMessageHelper messageHelper = null;

		try {
			message = mailSender.createMimeMessage();
			messageHelper = new MimeMessageHelper(message, true, "utf-8");

			messageHelper.setSubject("communityexample에서 아이디와 비밀번호를 알려드립니다");
			messageHelper.setTo(memberDto.getmEmail());
			messageHelper.setText("아이디 : " + memberDto.getmId() + "\r\n 비밀번호 : " + memberDto.getmPassword());
			mailSender.send(message);

			result = SUCCESS;
		} catch (MessagingException e) {
			log.debug("sendMail() - catch");
			e.printStackTrace();

			result = FAIL;
		}

		return result;
	}

	@Override
	public int idCheck(String mId) {
		int result = 0;

		// 받은 id로 검색해서 데이터 유무 확인
		result = memberDao.idCheck(mId);
		if (result == 0) {
			result = SUCCESS;
		} else {
			result = FAIL;
		}

		return result;
	}

	@Override
	public int nicknameCheck(String mNickname) {
		int result = 0;

		result = memberDao.nicknameCheck(mNickname);
		if (result == 0) {
			result = SUCCESS;
		} else {
			result = FAIL;
		}

		return result;
	}

	@Override
	public int emailCheck(String mEmail) {
		int result = 0;

		// 받은 email로 검색해서 데이터 유무 확인
		result = memberDao.emailCheck(mEmail);
		if (result == 0) {
			result = SUCCESS;
		} else {
			result = FAIL;
		}

		return result;
	}

	@Override
	public MemberDTO join(MemberDTO memberDto) {
		int result = 0;

		// 1.mPassword 해쉬화
		memberDto.setmPassword(hashHelper.hashByBCrypt(memberDto.getmPassword()));
		// 2.insert
		result = memberDao.join(memberDto);
		if (result == SUCCESS) {
			result = memberDao.insertMemberInfo(memberDto.getmId());
			// 3. insert한 memberDto 받아오기
			memberDto = memberDao.getMemberDto(memberDto.getmId());
		} else if (result != SUCCESS) {
			memberDto = null;
		}

		return memberDto;
	}

	@Override
	public MemberDTO findAccount(String mEmail) {
		int result = 0;
		int randomPassword = 0;
		String hashedPassword = null;
		Random random = new Random();
		MemberDTO memberDto = new MemberDTO();

		// 1.변경할 무작위수 생성
		randomPassword = random.nextInt(1000000);
		// 2.해당 무작위수 해쉬화
		hashedPassword = hashHelper.hashByBCrypt(randomPassword + "");
		// 3. mdto에 주입
		memberDto.setmEmail(mEmail);
		memberDto.setmPassword(hashedPassword);
		// 4.해싱한 비밀번호로 변경
		result = memberDao.findAccount(memberDto);
		if (result == SUCCESS) {
			memberDto.setmId(memberDao.getId(memberDto.getmEmail()));
			memberDto.setmPassword("" + randomPassword);
		} else if (result != SUCCESS) {
			memberDto = null;
		}

		return memberDto;
	}

	@Override
	public Map<String,Object> login(MemberDTO memberDto) {
		boolean result = false;
		Map<String,Object> resultMap=null;
		String hashedPassword = null;
		List<BookmarkBoardDTO> bookmarkBoardDtoList=null;
		
		// 1.form에서 입력한 mId를 조건으로 db에서 pw만 가져오기
		hashedPassword = memberDao.getPassword(memberDto.getmId()); // TODO id로 검색한 결과가 없을때 hashedPassword에 반환될 값은??
		// 2.form에서 넘어온 pw와 db의 pw를 해싱컴포넌트에서 비교
		if (!hashedPassword.equals("1이 실패시 저장될값")) {
			result = hashHelper.matchByBCrypt(memberDto.getmPassword(), hashedPassword);
			// 3.비밀번호 일치시 logindate수정, memberDto 가져오기
			if (result) {
				resultMap=new HashMap<String,Object>();
				memberDao.login(memberDto.getmId());
				memberDto = memberDao.getMemberDto(memberDto.getmId());
				bookmarkBoardDtoList=memberDao.bookmarkBoardList(memberDto.getmId());
				resultMap.put("memberDto", memberDto);
				resultMap.put("bookmarkBoardDtoList", bookmarkBoardDtoList);
			} else {
				resultMap = null;
			}
		}

		return resultMap;
	}

	@Override
	public Map<String, Object> memberInfo(String mId) {
		Map<String, Object> dtoMap = new HashMap<String, Object>();
		Iterator<String> dtoMapKeyIterator = null;
		
		log.debug("memberInfo();");
		// 세션의 id에 해당하는 회원 정보들 가져오기(회원정보, 보유아이콘, 아이콘 위시리스트, 즐겨찾기한 게시판, 즐겨찾기한 게시물,)
		dtoMap.put("memberDto", memberDao.getMemberDto(mId));
		dtoMap.put("memberItemDtoList", memberDao.getMemberItem(mId));
		dtoMap.put("wishListDtoList", shopDao.getWishlistDTO(mId));
		dtoMap.put("bookmarkBoardDtoList", memberDao.bookmarkBoardList(mId));
		dtoMap.put("bookmarkArticleDtoList", memberDao.bookmarkArticleList(mId));
		// map에 넣은 dto중 null이 있는지 확인하고 하나라도 null이 있으면 map자체를 null로 변경
		dtoMapKeyIterator= dtoMap.keySet().iterator();
		while(dtoMapKeyIterator.hasNext()) {
			String key=dtoMapKeyIterator.next();
			if(dtoMap.get(key)==null) {
				dtoMap=null;
			}
		}

		return dtoMap;
	}

	@Override
	public int modifyInfo(MemberDTO memberDto) {
		int result = 0;

		// 입력한 값으로 해당회원 정보수정
		result = memberDao.modify(memberDto);
		if (result != SUCCESS) {
			result = FAIL;
		}

		return result;
	}

	@Override
	public int withdraw(MemberDTO memberDto) {
		int result = 0;
		String hashedPassword = null;

		// 1.mId를 조건으로 db에서 pw만 가져오기
		hashedPassword = memberDao.getPassword(memberDto.getmId()); // TODO 검색결과가 없을때 hashedPassword에 반환될 값은??
		// 2.입력한 pw와 db의 pw를 해싱컴포넌트에서 비교
		if (!hashedPassword.equals("1의 결과가 없을때 저장될 값")) {
			if (hashHelper.matchByBCrypt(memberDto.getmPassword(), hashedPassword)) {
				// 3.해당 회원에 관련된 기본정보 삭제
				result = memberDao.deleteMember(memberDto.getmId());
			}
		}

		return result;
	}

	/*
	 * @Override public int auth(MemberAuthDTO memberAuthDto) { int result=0;
	 * 
	 * //입력한 인증키를 테이블상의 인증키와 대조해보고 알맞을경우 진행, 아닐경우 빠꾸
	 * 
	 * return result; }
	 */
}
