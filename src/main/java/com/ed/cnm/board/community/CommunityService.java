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
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return communityDAO.getSelect(boardDTO);
	}
	
	@Override
	public int setInsert(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		long num = communityDAO.getNum();
		boardDTO.setNum(num);
		int result = communityDAO.setInsert(boardDTO);
		
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
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return communityDAO.setDelete(boardDTO);
	}
	
	@Override
	public int setUpdate(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		for(MultipartFile multipartFile:files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			// file들을 HDD에 저장
			String fileName = fileManager.save("community", multipartFile, session);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriginName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			// DB에 insert
			communityDAO.setFileInsert(boardFileDTO);
		}
		return communityDAO.setUpdate(boardDTO);
	}
	
	public boolean setSummerFileDelete(String fileName)throws Exception{
		boolean result = fileManager.delete("community", fileName, session);
		return result;
	}
	
	public String setSummerFileUpload(MultipartFile file)throws Exception{
		
		String fileName = fileManager.save("community", file, session);
		return fileName;
	}
	
	
	public int setFileDelete(BoardFileDTO boardFileDTO)throws Exception{
		// 조회
		boardFileDTO = communityDAO.getFileSelect(boardFileDTO);
		// table 삭제
		int result = communityDAO.setFileDelete(boardFileDTO);
		// HDD 삭제
		if(result > 0) {
			fileManager.delete("community", boardFileDTO.getFileName(), session);
		}
		return result;
	}

}