package com.ce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dao.ShopDAO;
import com.ce.dto.ShopCommentDTO;
import com.ce.dto.ShopDTO;

public class ShopServiceImpl implements ShopService{
	private ShopDAO shopDao;
	final int SUCCESS=1;
	final int FAIL=-1;
	

	public void setShopDao(ShopDAO shopDao) {
		this.shopDao = shopDao;
	}

	private int stringIdxToInteger(String index) {
		int result = 0;
		try {
			result = Integer.parseInt(index);
		} catch (NumberFormatException ne) {
			result = -1;
		}
		return result;
	}
	
	@Override
	public Map<String, List<ShopDTO>> main() {
		Map<String, List<ShopDTO>> shopDtoListMap=null;
		
		//아이콘과 프로필의 글들 최신순으로 몇개 가져오기
		shopDtoListMap=shopDao.main();
		
		return shopDtoListMap;
	}

	@Override
	public List<ShopDTO> iconList(ShopDTO shopDto, PageHelper pageHelper) {
		List<ShopDTO> iconDtoList=null;
		shopDto.setPageHelper(pageHelper);
		
		//아이콘의 글들을 page를 이용해 가져오기
		iconDtoList=shopDao.iconList(shopDto);
		
		return iconDtoList;
	}

	@Override
	public Map<String, Object> content(String stringShopIdx) {
		Map<String,Object> contentMap=new HashMap<String,Object>();
		List<ShopCommentDTO> shopCommentDtoList=null;
		ShopCommentDTO shopCommentDto =new ShopCommentDTO();
		PageHelper pageHelper = new PageHelper(); 
		int sIdx=0;
		
		if (stringIdxToInteger(stringShopIdx) != FAIL) {
			sIdx = stringIdxToInteger(stringShopIdx);
		//댓글dto세팅
		shopCommentDto.setsIdx(sIdx);
		shopCommentDto.setPageHelper(pageHelper);
		//해당 idx의 정보 가져오기
		ShopDTO shopDto=shopDao.content(sIdx);
		// 해당 idx의 댓글 가져오기
		shopCommentDtoList=shopDao.comment(shopCommentDto);
		
		//map에 담아서 리턴
		contentMap.put("shopDto", shopDto);
		contentMap.put("shopCommentDtoList", shopCommentDtoList);
		}
		
		return contentMap;
	}

	@Override
	public List<ShopCommentDTO> comment(ShopCommentDTO shopCommentDto, PageHelper pageHelper) {
		List<ShopCommentDTO> shopCommentDtoList = null;
		
		//sidx를 받아서 해당 sidx의 댓글목록을 page를 이용해 가져옴
		//(ajax로 댓글목록만 가져와서 댓글목록만 재조립함)
		shopCommentDtoList=shopDao.comment(shopCommentDto);
		
		return shopCommentDtoList;
	}

	@Override
	public int write(ShopDTO shopDto) {
		int result=0;
		
		//상점테이블에 row 등록
		result=shopDao.write(shopDto);
		
		return result;
	}

	@Override
	public ShopDTO modifyForm(int sIdx) {
		ShopDTO shopDto = null;
		
		//해당글 가져오기
		shopDto=shopDao.getShopDTO(sIdx);
		
		return shopDto;
	}

	@Override
	public int modify(ShopDTO shopDto) {
		int result=0;
		
		//row 수정
		result=shopDao.modify(shopDto);
		
		return result;
	}

	@Override
	public int delete(int sIdx) {
		int result=0;
		
		//row 삭제
		result=shopDao.delete(sIdx);
		
		return result;
	}

	@Override
	public int writeComment(ShopCommentDTO shopCommentDto) {
		int result=0;
		
		//sIndex와 연관짓는 댓글 row 등록
		result=shopDao.writeComment(shopCommentDto);
		
		return result;
	}

	@Override
	public int deleteComment(int scIdx) {
		int result=0; 
		
		//해당 row 삭제
		result=shopDao.deleteComment(scIdx);
		
		return result;
	}

	@Override
	public int modifyComment(ShopCommentDTO shopCommentDto) {
		int result=0;
		
		//해당 row의 컬럼값 수정
		result=shopDao.modifyComment(shopCommentDto);
		
		return result;
	}

	@Override
	public int replyComment(ShopCommentDTO shopCommentDto) {
		int result=0;
		
		//group, step, indent 작업
		
		//해당댓글과 연관되는 댓글row 입력
		result=shopDao.writeComment(shopCommentDto);
		
		return result;
	}

	@Override
	public List<ShopDTO> search(PageHelper pageHelper, SearchHelper searchHelper) {
		List<ShopDTO> shopDtoList=null;
		ShopDTO shopDto = new ShopDTO();
		
		//page,search dto에 저장
		shopDto.setPageHelper(pageHelper);
		shopDto.setSearchHelper(searchHelper);		
		//query와 target 그리고 page를 이용해서 검색한 결과 가져오기
		shopDtoList=shopDao.search(shopDto);
		
		return shopDtoList;
	}
	
	//  public ? purchase(?); //구매테이블에 row입력, 회원정보 중 금액감소, 장바구니 테이블에서 해당아이템 row 제거
	//  public ? cart(?); //내 cart목록 가져오기
	//  public ? addCart(?); //cart테이블에 추가
	//  public ? wishList(?); //해당아이템 북마크 등록유무 검색후 없으면 등록 있으면 삭제

	@Override
	public int report(ShopDTO shopDto) {
		int result=0;
		
		//해당글을 report한 이력이 있는지 확인
		result=shopDao.countReport(shopDto);
		//이력이 없을시 해당글 report갯수 증가
		//본인의 해당글 report이력 db등록
		if(result==0) {
			result=shopDao.increaseReport(shopDto);
			if(result==1) {
				result=shopDao.writeReportInfo(shopDto);
			}			
		}else if(result==1) {
			result=FAIL;
		}
		
		return result;
	}

	@Override
	public int thumbsUpContent(ShopDTO shopDto) {
		int result=0;
		
		//해당글을 추천한 이력이 있는지 확인
		result=shopDao.countVoteArticle(shopDto);
		//이력이 없을시 sIdx글 추천수증가
		//해당글 추천mId 등록 
		if(result==0) {	
			result=shopDao.thumbsUpArticle(shopDto);
			if(result==1) {
				result=shopDao.writeVoteArticleInfo(shopDto);
			}
		}else if(result==1) {
			result=FAIL;
		}
		
		return result;
	}

	@Override
	public int thumbsDownContent(ShopDTO shopDto) {
		int result=0;
		
		//해당글을 비추천한 이력이 있는지 확인
		result=shopDao.countVoteArticle(shopDto);
		//이력이 없을시 sIdx글 추천수감소 
		//해당글 추천mId 등록
		if(result==0) {	
			result=shopDao.thumbsDownArticle(shopDto);
			if(result==1) {
				result=shopDao.writeVoteArticleInfo(shopDto);
			}
		}else if(result==1) {
			result=FAIL;
		}
		
		return result;
	}

	@Override
	public int thumbsUpComment(ShopCommentDTO shopCommentDto) {
		int result=0;
		
		//해당댓글을 추천한 이력이 있는지 확인
		result=shopDao.countVoteComment(shopCommentDto);
		//이력이 없을시 scIdx글 추천수증가 
		//해당글 추천mId 등록
		if(result==0) {
			result=shopDao.thumbsUpComment(shopCommentDto);
			if(result==1) {
				result=shopDao.writeVoteCommentInfo(shopCommentDto);
			}
		}else if(result==1) {
			result=FAIL;
		}
		
		return result;
	}

	@Override
	public int thumbsDownComment(ShopCommentDTO shopCommentDto) {
		int result=0;
		
		//해당댓글을 비추천한 이력이 있는지 확인
		result=shopDao.countVoteComment(shopCommentDto);				
		//이력이 없을시 scIdx글 추천수감소 
		//해당글 추천mId 등록
		if(result==0) {
			result=shopDao.thumbsDownComment(shopCommentDto);
			if(result==1) {
				result=shopDao.writeVoteCommentInfo(shopCommentDto);
			}
		}else if(result==1) {
			result=FAIL;
		}
		
		return result;
	}

}
