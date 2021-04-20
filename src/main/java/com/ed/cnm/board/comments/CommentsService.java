package com.ed.cnm.board.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentsService {

	@Autowired
	private CommentsDAO commentsDAO;
	
	public int setInsert(CommentsDTO commentsDTO) throws Exception {
		return commentsDAO.setInsert(commentsDTO);
	}
	
	public List<CommentsDTO> getList(CommentsDTO commentsDTO) throws Exception {
		return commentsDAO.getList(commentsDTO);
	}
}
