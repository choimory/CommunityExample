package com.ce.dao;

import java.util.List;
import java.util.Map;

import com.ce.component.PageHelper;
import com.ce.dto.ShopCommentDTO;
import com.ce.dto.ShopDTO;
import com.ce.dto.WishlistDTO;

public interface ShopDAO {
	public List<ShopDTO> waitingPermissionList(); //select all where permission 
	public List<ShopDTO> waitingPermissionList(PageHelper pageHelper); //select all where permission 
	public int permission(int sIdx); // update permission where sIdx 
	public WishlistDTO getWishlistDTO (String mId); // select all where mId
	public Map<String,List<ShopDTO>> main(); // select all from 1~10
	public List<ShopDTO> iconList(ShopDTO shopDto); // page를 이용해 select all 
	public ShopDTO content(int sIdx); //select all where sIdx
	public List<ShopCommentDTO> comment(ShopCommentDTO shopCommentDto); // page를 이용해 select all where sIdx from 1~20
	public int write(ShopDTO shopDto);//insert
	public ShopDTO getShopDTO(int sIdx);
	public int modify(ShopDTO shopDto); // update where sIdx
	public int delete(int sIdx); //delete where sIdx
	public int writeComment(ShopCommentDTO shopCommentDto); //insert
	public int deleteComment(int scIdx); //delete where scIdx
	public int modifyComment(ShopCommentDTO shopCommentDto); //update where scIdx
	public List<ShopDTO> search(ShopDTO shopDto); // select where query target from page
	public int countReport(ShopDTO shopDto); // count where sIdx, mId
	public int increaseReport(ShopDTO shopDto); // update report where sIdx
	public int writeReportInfo(ShopDTO shopDto); // insert mId, sIdx
	public int countVoteArticle(ShopDTO shopDto); //count where sIdx, mId
	public int thumbsUpArticle(ShopDTO shopDto);//update upvote where sIdx
	public int thumbsDownArticle(ShopDTO shopDto);//update downvote where sIdx
	public int writeVoteArticleInfo(ShopDTO shopDtop); //insert mId, sIdx
	public int countVoteComment(ShopCommentDTO shopCommentDto);//count where scIdx, mId
	public int thumbsUpComment(ShopCommentDTO shopCommentDto);//update upvote where scIdx
	public int thumbsDownComment(ShopCommentDTO shopCommentDto);//update downvote where scIdx
	public int writeVoteCommentInfo(ShopCommentDTO shopCommentDto); //insert mIdx, scIdx
}
