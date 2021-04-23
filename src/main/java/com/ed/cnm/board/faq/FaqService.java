package com.ed.cnm.board.faq;

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
public class FaqService implements BoardService {
	
	@Autowired
	private FaqDAO faqDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private HttpSession session;

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();
		long totalCount = faqDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		
		return faqDAO.getList(pager);
	}
	
	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		int result = faqDAO.setHitUpdate(boardDTO);
		return faqDAO.getSelect(boardDTO);
	}
	
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		long num = faqDAO.getNum();
		boardDTO.setNum(num);
		int result = faqDAO.setInsert(boardDTO);
		
		for(MultipartFile mf : files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			String fileName= fileManager.save("faq", mf, session);
			
			boardFileDTO.setNum(num);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriginName(mf.getOriginalFilename());
			
			faqDAO.setFileInsert(boardFileDTO);
		}
		return result;
	}
	
	public int setUpdate(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		for(MultipartFile multipartFile:files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			// File들을 HDD에 저장
			String fileName= fileManager.save("faq", multipartFile, session);
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriginName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			// DB에 Insert
			faqDAO.setFileInsert(boardFileDTO);
		}
		return faqDAO.setUpdate(boardDTO);
	}
	
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		return faqDAO.setDelete(boardDTO);
	}
	
	public String setSummerFileUpload(MultipartFile file)throws Exception{
		String fileName = fileManager.save("faq", file, session);
		return fileName;
	}
	
	public boolean setSummerFileDelete(String fileName)throws Exception{
		boolean result = fileManager.delete("faq", fileName, session);
		return result;
	}
	
	public int setFileDelete(BoardFileDTO boardFileDTO)throws Exception{
		// 조회
		boardFileDTO = faqDAO.getFileSelect(boardFileDTO);
		// 삭제
		int result = faqDAO.setFileDelete(boardFileDTO);
		// 삭제
		if(result > 0) {
			fileManager.delete("faq", boardFileDTO.getFileName(), session);
		}
		return result;
	}
	
}
