package com.ed.cnm.board;

import java.util.List;

import com.ed.cnm.util.Pager;


public interface BoardDAO {
	
	//==List==
	public List<BoardDTO> getList(Pager pager) throws Exception;
	//==TotalCount==
	public long getTotalCount(Pager pager) throws Exception;
	//==Select==
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception;
	//==Insert==
//	public int setInsert(BoardDTO boardDTO) throws Exception;
	//==Delete==
	public int setDelete(BoardDTO boardDTO) throws Exception;
	//==Update==
//	public int setUpdate(BoardDTO boardDTO) throws Exception;
	//==Hit Update==
	public int setHitUpdate(BoardDTO boardDTO) throws Exception;
	//==insertFile
	public int setFileInsert(BoardFileDTO boardFileDTO) throws Exception;
	//==DeleteFile
	public int setFileDelete(BoardFileDTO boardFileDTO) throws Exception;
	
	
}
