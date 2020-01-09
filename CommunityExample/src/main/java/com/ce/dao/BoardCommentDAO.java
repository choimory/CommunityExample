package com.ce.dao;

import java.util.List;

import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.VoteCommentDTO;

public interface BoardCommentDAO {
	public List<BoardCommentDTO> commentList(BoardDTO boardDto); // select all from BoardTypeComment where bIdx
	public List<BoardCommentDTO> comment(BoardCommentDTO boardCommentDto); //select all from bcomment where page
	public int writeComment(BoardCommentDTO boardCommentDto); //insert comment
	public int writeCommentInfo(BoardCommentDTO boardCommentDto); // insert comment info
	public int modifyComment(BoardCommentDTO boardCommentDto); //update comment
	public int modifyCommentInfo(BoardCommentDTO boardCommentDto); // update comment info
	public int deleteComment(BoardCommentDTO boardCommentDto); // delete comment where bcidx
	public int deleteCommentInfo(BoardCommentDTO boardCommentDto); // delete comment info where bcidx
	public int replyComment(BoardCommentDTO boardCommentDto); // insert comment
	public int checkVoteCommentAlready(VoteCommentDTO voteCommentDto);//count where mId, bId, bcIdx
	public int updateCommentVoteNum(VoteCommentDTO voteCommentDto); // update vote +_1 where bcIdx
	public int writeVoteCommentInfo(VoteCommentDTO voteCommentDto); //insert
}
