package com.ce.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dao.ShopDAO;
import com.ce.dto.ShopCommentDTO;
import com.ce.dto.ShopDTO;
import com.ce.dto.ShopVoteArticleDTO;
import com.ce.dto.ShopVoteCommentDTO;

public class ShopServiceImpl implements ShopService {
	private ShopDAO shopDao;
	final int SUCCESS = 1;
	final int FAIL = -1;

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

	private void paging(PageHelper pageHelper, int totalRow) {
		pageHelper.list();
		pageHelper.pagination2(totalRow);
	}

	@Override
	public Map<String, List<ShopDTO>> main() {
		Map<String, List<ShopDTO>> shopDtoListMap = null;

		// 아이콘과 프로필의 글들 최신순으로 몇개 가져오기
		shopDtoListMap = shopDao.main();

		return shopDtoListMap;
	}

	@Override
	public List<ShopDTO> list(ShopDTO shopDto, PageHelper pageHelper) {
		List<ShopDTO> shopDtoList = null;

		// 페이지 작업
		paging(pageHelper, shopDao.getTotalRow());
		shopDto.setPageHelper(pageHelper);
		// 아이콘의 글들을 page를 이용해 가져오기
		shopDtoList = shopDao.list(shopDto);

		return shopDtoList;
	}

	@Override
	public Map<String, Object> content(String stringShopIdx,PageHelper pageHelper) {
		Map<String, Object> contentMap = new HashMap<String, Object>();
		List<ShopDTO> shopDtoList=null;
		List<ShopCommentDTO> shopCommentDtoList = null;
		ShopCommentDTO shopCommentDto = new ShopCommentDTO();
		ShopDTO shopDto =null;
		int sIdx = 0;

		if (stringIdxToInteger(stringShopIdx) != FAIL) {
			sIdx = stringIdxToInteger(stringShopIdx);
			// 글가져오기
			shopDto = shopDao.content(sIdx);
			// 댓글dto세팅
			shopCommentDto.setsIdx(sIdx);
			// 댓글 가져오기 (content에서는 댓글의 페이징은 필요없다. 댓글페이징은 comment에서 ajax로 댓글만 페이징이 따로 이뤄질것이기 때문에)
			shopCommentDto.setPageHelper(new PageHelper());
			shopCommentDtoList = shopDao.comment(shopCommentDto);
			// 글목록 가져오기.  
			paging(pageHelper, shopDao.getTotalRow());
			shopDto.setPageHelper(pageHelper);
			shopDtoList=shopDao.list(shopDto);
			
			// map에 담아서 리턴
			contentMap.put("shopDto", shopDto);
			contentMap.put("shopCommentDtoList", shopCommentDtoList);
			contentMap.put("shopDtoList", shopDtoList);
		}

		return contentMap;
	}

	@Override
	public List<ShopCommentDTO> comment(ShopCommentDTO shopCommentDto, PageHelper pageHelper) {
		List<ShopCommentDTO> shopCommentDtoList = null;
		ShopDTO shopDto=null;
		
		// 댓글 페이징
		shopDto=shopDao.getShopDto(shopCommentDto.getsIdx());
		paging(pageHelper,shopDto.getShopInfoDto().getsCommentNum());
		shopCommentDto.setPageHelper(pageHelper);
		// 페이지에 해당되는 댓글목록 select
		shopCommentDtoList = shopDao.comment(shopCommentDto);

		return shopCommentDtoList;
	}

	@Override
	public int write(ShopDTO shopDto) {
		int result = 0;

		// 상점테이블에 row 등록
		result = shopDao.write(shopDto);
		if (result == SUCCESS) {
			result = shopDao.writeInfo(shopDto);
		}
		
		return result;
	}

	@Override
	public ShopDTO modifyForm(int sIdx) {
		ShopDTO shopDto = null;

		// 해당글 가져오기
		shopDto = shopDao.getShopDto(sIdx);

		return shopDto;
	}

	@Override
	public int modify(ShopDTO shopDto) {
		int result = 0;

		// row 수정
		result = shopDao.modify(shopDto);

		return result;
	}

	@Override
	public int delete(int sIdx) {
		int result = 0;

		// row 삭제
		result = shopDao.delete(sIdx);
		
		return result;
	}

	@Override
	public int writeComment(ShopCommentDTO shopCommentDto) {
		int result = 0;

		// scGroup을 scIdx로 설정
		shopCommentDto.setScGroup(shopDao.commentGrouping(shopCommentDto.getsIdx()+1));
		// sIndex와 연관짓는 댓글 row 등록
		result = shopDao.writeComment(shopCommentDto);
		result = shopDao.writeCommmentInfo(shopCommentDto);

		return result;
	}

	@Override
	public int deleteComment(int scIdx) {
		int result = 0;

		// 해당 row 삭제
		result = shopDao.deleteComment(scIdx);

		return result;
	}

	@Override
	public int modifyComment(ShopCommentDTO shopCommentDto) {
		int result = 0;

		// 해당 row의 컬럼값 수정
		result = shopDao.modifyComment(shopCommentDto);

		return result;
	}

	@Override
	public int replyComment(ShopCommentDTO shopCommentDto) {
		int result = 0;
		Map<String,Integer> paramMap=new HashMap<String,Integer>();
		
		// 댓글대상의 group, step, indent 작업
		// 클라이언트단에서 넘겨준단 가정하에 생략(댓글대상과 group은 동일하게, step indent는 1증가시키기)		
		// 해당댓글과 연관되는 댓글row 입력
		result = shopDao.writeComment(shopCommentDto);
		// 다른 댓글들 step증가시키기
		paramMap.put("scGroup", shopCommentDto.getScGroup());
		paramMap.put("scStep", shopCommentDto.getScStep());
		shopDao.increaseStep(paramMap);

		return result;
	}

	@Override
	public List<ShopDTO> search(PageHelper pageHelper, SearchHelper searchHelper) {
		List<ShopDTO> shopDtoList = null;
		ShopDTO shopDto = new ShopDTO();

		// page,search dto에 저장
		shopDto.setPageHelper(pageHelper);
		shopDto.setSearchHelper(searchHelper);
		// query와 target 그리고 page를 이용해서 검색한 결과 가져오기
		shopDtoList = shopDao.search(shopDto);

		return shopDtoList;
	}

	// public ? purchase(?); //구매테이블에 row입력, 회원정보 중 금액감소, 장바구니 테이블에서 해당아이템 row 제거
	// public ? cart(?); //내 cart목록 가져오기
	// public ? addCart(?); //cart테이블에 추가
	// public ? wishList(?); //해당아이템 북마크 등록유무 검색후 없으면 등록 있으면 삭제

	@Override
	public int report(ShopDTO shopDto) {
		int result = 0;

		// 해당글을 report한 이력이 있는지 확인
		result = shopDao.checkReport(shopDto);
		// 이력이 없을시 해당글 report갯수 증가
		// 본인의 해당글 report이력 db등록
		if (result == 0) {
			result = shopDao.increaseReport(shopDto);
			if (result == 1) {
				result = shopDao.writeReportArticle(shopDto);
			}
		} else if (result == 1) {
			result = FAIL;
		}

		return result;
	}

	@Override
	public int thumbsUpContent(ShopVoteArticleDTO shopVoteArticleDto) {
		int result = 0;

		// 해당글을 추천한 이력이 있는지 확인
		result = shopDao.checkVoteArticle(shopVoteArticleDto);
		// 이력이 없을시 sIdx글 추천수증가
		// 해당글 추천mId 등록
		if (result == 0) {
			result = shopDao.thumbsUpArticle(shopVoteArticleDto);
			if (result == 1) {
				result = shopDao.writeVoteArticleInfo(shopVoteArticleDto);
			}
		} else if (result == 1) {
			result = FAIL;
		}

		return result;
	}

	@Override
	public int thumbsDownContent(ShopVoteArticleDTO shopVoteArticleDto) {
		int result = 0;

		// 해당글을 비추천한 이력이 있는지 확인
		result = shopDao.checkVoteArticle(shopVoteArticleDto);
		// 이력이 없을시 sIdx글 추천수감소
		// 해당글 추천mId 등록
		if (result == 0) {
			result = shopDao.thumbsDownArticle(shopVoteArticleDto);
			if (result == 1) {
				result = shopDao.writeVoteArticleInfo(shopVoteArticleDto);
			}
		} else if (result == 1) {
			result = FAIL;
		}

		return result;
	}

	@Override
	public int thumbsUpComment(ShopVoteCommentDTO shopVoteCommentDto) {
		int result = 0;

		// 해당댓글을 추천한 이력이 있는지 확인
		result = shopDao.checkVoteComment(shopVoteCommentDto);
		// 이력이 없을시 scIdx글 추천수증가
		// 해당글 추천mId 등록
		if (result == 0) {
			result = shopDao.thumbsUpComment(shopVoteCommentDto);
			if (result == 1) {
				result = shopDao.writeVoteCommentInfo(shopVoteCommentDto);
			}
		} else if (result == 1) {
			result = FAIL;
		}

		return result;
	}

	@Override
	public int thumbsDownComment(ShopVoteCommentDTO shopVoteCommentDto) {
		int result = 0;

		// 해당댓글을 비추천한 이력이 있는지 확인
		result = shopDao.checkVoteComment(shopVoteCommentDto);
		// 이력이 없을시 scIdx글 추천수감소
		// 해당글 추천mId 등록
		if (result == 0) {
			result = shopDao.thumbsDownComment(shopVoteCommentDto);
			if (result == 1) {
				result = shopDao.writeVoteCommentInfo(shopVoteCommentDto);
			}
		} else if (result == 1) {
			result = FAIL;
		}

		return result;
	}

}
