package com.ed.cnm.board.community;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ed.cnm.board.BoardDTO;
import com.ed.cnm.board.BoardService;
import com.ed.cnm.util.Pager;

@Service
public class CommunityService implements BoardService {
	
	@Autowired
	private CommunityDAO communityDAO;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.getList(pager);
	}
	
	@Override
	public long getTotalCount(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.getTotalCount(pager);
	}
	
	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.getSelect(boardDTO);
	}
	
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.setDelete(boardDTO);
	}
	
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.setInsert(boardDTO);
	}
	
	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.setUpdate(boardDTO);
	}

}
