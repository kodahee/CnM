package com.ed.cnm.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ed.cnm.board.BoardDTO;
import com.ed.cnm.board.BoardFileDTO;
import com.ed.cnm.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@GetMapping("noticeList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getCurPage());
		
		List<BoardDTO> ar = noticeService.getList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		mv.addObject("board", "notice");
		mv.addObject("pager", pager);
		mv.addObject("nav","serviceCenter");
		
		return mv;
	}
	
	@GetMapping("noticeSelect")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}

	@GetMapping("noticeInsert")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "notice");
		return mv;
	}
	
	@PostMapping("noticeInsert")
	public String setInsert(BoardDTO boardDTO, Model model, MultipartFile [] files) throws Exception {
		
		int result = noticeService.setInsert(boardDTO, files);
		
		
		String message="등록 실패";
		
		if(result>0) {
			message="등록 성공";
		}
		model.addAttribute("msg", message);
		model.addAttribute("path", "./noticeList");
		
		return "common/commonResult";
	}
	
	@GetMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getSelect(boardDTO);
		
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "notice");
		mv.setViewName("board/boardUpdate");
		return mv;
	}
	
	@PostMapping("noticeUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv, MultipartFile [] files) throws Exception {
		
		int result = noticeService.setUpdate(boardDTO, files);
		
		if(result>0) {
			//성공하면 리스트로 이동
			mv.setViewName("redirect:./noticeList");
		}else {
			//실패하면 수정실패 , 리스트로 이동
			mv.addObject("msg", "수정 실패");
			mv.addObject("path", "./noticeList");
			mv.setViewName("common/commonResult");
		}
		
		return mv;
	}
	
	@PostMapping("noticeDelete")
	public ModelAndView setDelete(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setDelete(boardDTO);
		
		String message="삭제 실패";
		String path = "./noticeList";
		
		if(result>0) {
			message="삭제 성공";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", path);
		
		mv.setViewName("common/commonResult");
		
		return mv;
	}
	
	@PostMapping("summerFileDelete")
	public ModelAndView setSummerFileDelete(String fileName) throws Exception {
		ModelAndView mv = new ModelAndView();
		boolean result = noticeService.setSummerFileDelete(fileName);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@PostMapping("summerFileUpload")
	public ModelAndView setSummerFileUpload(MultipartFile file) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Summer File Upload");
		System.out.println(file.getOriginalFilename());
		String fileName = noticeService.setSummerFileUpload(file);
		fileName = "../resources/upload/notice/"+fileName;
		mv.addObject("result", fileName);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@GetMapping("fileDelete")
	public ModelAndView setFileDelete(BoardFileDTO boardFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setFileDelete(boardFileDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}

}