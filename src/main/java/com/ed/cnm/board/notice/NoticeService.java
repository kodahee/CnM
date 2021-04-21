package com.ed.cnm.board.notice;

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
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();

		long totalCount = noticeDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		
		return noticeDAO.getList(pager);
	}
	
	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.getSelect(boardDTO);
	}
	
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		long num =noticeDAO.getNum();
		boardDTO.setNum(num);
		int result = noticeDAO.setInsert(boardDTO);
		
		//글번호 찾기
		for(MultipartFile mf : files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			String fileName= fileManager.save("notice", mf, session);
			
			boardFileDTO.setNum(num);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriginName(mf.getOriginalFilename());
			
			noticeDAO.setFileInsert(boardFileDTO);
		}
		return result;//noticeDAO.setInsert(boardDTO);
	}
	
	public int setUpdate(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		for(MultipartFile multipartFile:files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			//1. File들을 HDD에 저장
			String fileName= fileManager.save("notice", multipartFile, session);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriginName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			//2. DB에 Insert
			noticeDAO.setFileInsert(boardFileDTO);
		}
		
		return noticeDAO.setUpdate(boardDTO);
	}
	
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.setDelete(boardDTO);
	}
	
	public boolean setSummerFileDelete(String fileName) throws Exception {
		boolean result = fileManager.delete("notice", fileName, session);
		return result;
	}
	
	public String setSummerFileUpload(MultipartFile file) throws Exception {
		
		String fileName = fileManager.save("notice", file, session);
		return fileName;
	}
	
	public int setFileDelete(BoardFileDTO boardFileDTO) throws Exception {
		// 조회
		boardFileDTO = noticeDAO.getFileSelect(boardFileDTO);
		// table 삭제
		int result = noticeDAO.setFileDelete(boardFileDTO);
		// HDD 삭제
		if(result > 0) {
			fileManager.delete("notice", boardFileDTO.getFileName(), session);
		}
		
		return result;
	}
	
}
