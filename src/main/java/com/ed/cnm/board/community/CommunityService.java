package com.ed.cnm.board.community;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ed.cnm.board.BoardDTO;
import com.ed.cnm.board.BoardFileDTO;
import com.ed.cnm.board.BoardService;
import com.ed.cnm.util.FileManager;
import com.ed.cnm.util.Pager;

@Service
public class CommunityService implements BoardService {
	
	@Autowired
	private CommunityDAO communityDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private HttpSession session;
	
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		
		long totalCount = communityDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		
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
	
//	@Override
	public int setInsert(CommunityDTO communityDTO, MultipartFile[] files) throws Exception {
		long num = communityDAO.getNum();
		communityDTO.setNum(num);
		int result = communityDAO.setInsert(communityDTO);
		
		// 글번호찾기
		for(MultipartFile mf : files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			String fileName = fileManager.save("community", mf, session);
			
			boardFileDTO.setNum(num);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriginName(mf.getOriginalFilename());
			
			communityDAO.setFileInsert(boardFileDTO);
		}
		
		return result;
	}
	
	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.setUpdate(boardDTO);
	}

}
