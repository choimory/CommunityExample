package com.ce.dao;

import java.util.List;
import java.util.Map;

import com.ce.component.PageHelper;
import com.ce.dto.ShopCommentDTO;
import com.ce.dto.ShopDTO;
import com.ce.dto.ShopInfoDTO;
import com.ce.dto.ShopVoteArticleDTO;
import com.ce.dto.ShopVoteCommentDTO;
import com.ce.dto.WishlistDTO;

public interface ShopDAO {
//	public List<ShopDTO> waitingPermissionList(); //select all where permission 
	public int getTotalRowWaitingPermission();
	public List<ShopDTO> waitingPermissionList(PageHelper pageHelper); //select all where permission
	public int permission(ShopInfoDTO shopInfoDto);
	public List<WishlistDTO> getWishlistDTO (String mId); // select all where mId
	
	//TODO 얘 반환타입 mybatis로 어떻게해야하는지 확인
	public Map<String,List<ShopDTO>> main(); // select all from 1~10
	
	public List<ShopDTO> list(ShopDTO shopDto); // page를 이용해 select all 
	public ShopDTO content(int sIdx); //select all where sIdx
	public List<ShopCommentDTO> comment(ShopCommentDTO shopCommentDto); // page를 이용해 select all where sIdx from 1~20
	public int write(ShopDTO shopDto);//insert shop values
	public int writeInfo(ShopDTO shopDto);//insert shop_info values
	public ShopDTO getShopDto(int sIdx);
	public int modify(ShopDTO shopDto); // update where sIdx
	public int delete(int sIdx); //delete where sIdx
	public int writeComment(ShopCommentDTO shopCommentDto); //insert
	public int writeCommmentInfo(ShopCommentDTO shopCommentDto); //insert
	public int deleteComment(int scIdx); //delete where scIdx
	public int modifyComment(ShopCommentDTO shopCommentDto); //update where scIdx
	public List<ShopDTO> search(ShopDTO shopDto); // select where query target from page
	public int checkReport(ShopDTO shopDto); // count where sIdx, mId
	public int increaseReport(ShopDTO shopDto); // update report where sIdx
	public int writeReportArticle(ShopDTO shopDto); // insert mId, sIdx
	public int checkVoteArticle(ShopVoteArticleDTO shopVoteArticleDto); //count where sIdx, mId
	public int thumbsUpArticle(ShopVoteArticleDTO shopVoteArticleDto);//update upvote where sIdx
	public int thumbsDownArticle(ShopVoteArticleDTO shopVoteArticleDto);//update downvote where sIdx
	public int writeVoteArticleInfo(ShopVoteArticleDTO shopVoteArticleDTO); //insert mId, sIdx
	public int checkVoteComment(ShopVoteCommentDTO shopVoteCommentDto);//count where scIdx, mId
	public int thumbsUpComment(ShopVoteCommentDTO shopVoteCommentDto);//update upvote where scIdx
	public int thumbsDownComment(ShopVoteCommentDTO shopVoteCommentDto);//update downvote where scIdx
	public int writeVoteCommentInfo(ShopVoteCommentDTO shopVoteCommentDTO); //insert mIdx, scIdx
	
	public int getTotalRow();//select count(*) 혹은 row전용테이블 select
	public int commentGrouping(int sIdx); // select MAX(SHOP_INDEX) FROM shop_comment WHERE SHOP_INDEX
	public int increaseStep(Map<String,Integer>paramMap);
}
