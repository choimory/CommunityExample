package com.ce.service;

import java.util.List;
import java.util.Map;

import com.ce.component.PageHelper;
import com.ce.component.SearchHelper;
import com.ce.dto.ShopCommentDTO;
import com.ce.dto.ShopDTO;
import com.ce.dto.ShopVoteArticleDTO;
import com.ce.dto.ShopVoteCommentDTO;

public interface ShopService {
	  public Map<String, List<ShopDTO>> main(); //아이콘과 프로필의 글들 최신순으로 몇개 가져오기
	  public List<ShopDTO> list(ShopDTO shopDto, PageHelper pageHelper); //아이콘의 글들을 page를 이용해 가져오기
	  public Map<String, Object> content(String stringShopIdx,PageHelper pageHelper); //해당 idx의 정보와 댓글들 가져오기
	  public List<ShopCommentDTO> comment(ShopCommentDTO shopCommentDto, PageHelper pageHelper); //해당 상점글의 댓글창의 페이지네이션을 이용했을때 해당 page의 댓글목록 가져오기
	  public int write(ShopDTO shopDto); //상점테이블에 row 등록
	  public ShopDTO modifyForm(int sIdx); //해당글 가져오기
	  public int modify(ShopDTO shopDto); //row 수정
	  public int delete(int sIdx); //row 삭제
	  public int writeComment(ShopCommentDTO shopCommentDto); //sIndex와 연관짓는 댓글 row 등록
	  public int deleteComment(int scIdx); //해당 row 삭제
	  public int modifyComment(ShopCommentDTO shopCommentDto); //해당 row의 컬럼값 수정
	  public int replyComment(ShopCommentDTO shopCommentDto); //해당댓글과 연관되는 댓글row 입력
	  public List<ShopDTO> search(PageHelper pageHelper, SearchHelper searchHelper); //query와 target 그리고 page를 이용해서 검색한 결과 가져오기
	//  public ? purchase(?); //구매테이블에 row입력, 회원정보 중 금액감소, 장바구니 테이블에서 해당아이템 row 제거
	//  public ? cart(?); //내 cart목록 가져오기
	//  public ? addCart(?); //cart테이블에 추가
	//  public ? wishList(?); //해당아이템 북마크 등록유무 검색후 없으면 등록 있으면 삭제
	  public int report(ShopDTO shopDto); //mId와 sIdx를 이용, 해당글 report갯수 추가, 본인의 해당글 report 정보 등록
	  public int thumbsUpContent(ShopVoteArticleDTO shopVoteArticleDto); //sIdx글 추천수증가, 해당글 추천mId 등록
	  public int thumbsDownContent(ShopVoteArticleDTO shopVoteArticleDto); //sIdx글 추천수감소, 해당글 추천mId 삭제
	  public int thumbsUpComment(ShopVoteCommentDTO shopVoteCommentDto); //scIdx댓글 추천수증가, 해당댓글 추천mId 등록
	  public int thumbsDownComment(ShopVoteCommentDTO shopVoteCommentDto); //scIdx댓글 추천수감소, 해당댓글 추천mId 제거

}
