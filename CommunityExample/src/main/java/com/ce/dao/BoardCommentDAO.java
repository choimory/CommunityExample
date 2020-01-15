package com.ce.dao;

import java.util.List;

import com.ce.dto.BoardCommentDTO;
import com.ce.dto.BoardDTO;
import com.ce.dto.VoteCommentDTO;

public interface BoardCommentDAO {
	public List<BoardCommentDTO> comment(BoardDTO boardDto);
	public List<BoardCommentDTO> comment(BoardCommentDTO boardCommentDto);
	public int writeComment(BoardCommentDTO boardCommentDto);
	public int writeCommentInfo(BoardCommentDTO boardCommentDto);
	public int modifyComment(BoardCommentDTO boardCommentDto);
	public int deleteComment(BoardCommentDTO boardCommentDto);
	public int checkVoteCommentAlready(VoteCommentDTO voteCommentDto);
	public int thumbsUpComment(VoteCommentDTO voteCommentDto);
	public int thumbsDownComment(VoteCommentDTO voteCommentDto);
	public int writeVoteComment(VoteCommentDTO voteCommentDto);
	public int getTotalRow(BoardCommentDTO boardCommentDto);
	public int commentGrouping(BoardCommentDTO boardCommentDto);
	public int goBest(VoteCommentDTO voteCommentDto);
}
