package com.ed.cnm.board;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ed.cnm.util.Pager;


public interface BoardService {
	
	//==List==
	public List<BoardDTO> getList(Pager pager) throws Exception; 
	//==Select==
	public BoardDTO getSelect(BoardDTO boardDTO)throws Exception;
	//==Insert==
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files)throws Exception;
	//==Delete== 
	public int setDelete(BoardDTO boardDTO)throws Exception;
	//==Update==
	public int setUpdate(BoardDTO boardDTO, MultipartFile [] files)throws Exception;
	
}
