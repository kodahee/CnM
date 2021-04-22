package com.ed.cnm.board.qna;

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
public class QnaService implements BoardService {
	
	@Autowired
	private QnaDAO qnaDAO;
	
	@Autowired
	private FileManager fileManager;
	
	@Autowired
	private HttpSession session;
	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		pager.makeRow();

		long totalCount = qnaDAO.getTotalCount(pager);
		pager.makeNum(totalCount);
		
		return qnaDAO.getList(pager);
	}
	
	@Override
	public BoardDTO getSelect(BoardDTO boardDTO) throws Exception {
		int result = qnaDAO.setHitUpdate(boardDTO);
		return qnaDAO.getSelect(boardDTO);
	}
	
	public int setInsert(BoardDTO boardDTO, MultipartFile [] files) throws Exception {
		int result = qnaDAO.setInsert(boardDTO);
		
		for(MultipartFile mf : files) {
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			String fileName= fileManager.save("qna", mf, session);
			
			boardFileDTO.setNum(boardDTO.getNum());
			boardFileDTO.setFileName(fileName);
			boardFileDTO.setOriginName(mf.getOriginalFilename());
			
			qnaDAO.setFileInsert(boardFileDTO);
		}
		return result;
	}
	
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		return qnaDAO.setUpdate(boardDTO);
	}
	
	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public int setReply(QnaDTO qnaDTO) throws Exception {
		// 부모글의 ref, step, depth 조회
		BoardDTO boardDTO = qnaDAO.getSelect(qnaDTO);
		QnaDTO parent = (QnaDTO)boardDTO;
		System.out.println(parent.getRef());
		System.out.println(parent.getStep());
		System.out.println(parent.getDepth());
		
		qnaDTO.setRef(parent.getRef());
		qnaDTO.setStep(parent.getStep()+1);
		qnaDTO.setDepth(parent.getDepth()+1);
		
		int result = qnaDAO.setReplyUpdate(parent);
		result = qnaDAO.setReply(qnaDTO);
		
		return result;
	}

}
