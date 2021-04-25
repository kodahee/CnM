package com.ed.cnm.board.faq;

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
@RequestMapping("/faq/**")
public class FaqController {
	
	@Autowired
	private FaqService faqService;
	
	@GetMapping("faqList")
	public ModelAndView getList(Pager pager)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(pager.getCurPage());
		
		List<BoardDTO> ar = faqService.getList(pager);
		
		mv.addObject("list", ar);
		mv.setViewName("board/boardList");
		mv.addObject("board", "faq");
		mv.addObject("pager", pager);
		
		return mv;
	}

	@GetMapping("faqSelect")
	public ModelAndView getSelect(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = faqService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "faq");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@GetMapping("faqInsert")
	public ModelAndView setInsert()throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "faq");
		return mv;
	}
	
	@PostMapping("faqInsert")
	public String setInsert(BoardDTO boardDTO, Model model, MultipartFile [] files)throws Exception{
		int result = faqService.setInsert(boardDTO, files);
		
		String message="등록 실패";
		
		if(result>0) {
			message="등록 성공";
		}
		model.addAttribute("msg", message);
		model.addAttribute("path", "./faqList");
		
		return "common/commonResult";
	}
	
	@GetMapping("faqUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardDTO = faqService.getSelect(boardDTO);
		
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "faq");
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@PostMapping("faqUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv, MultipartFile [] files) throws Exception{
		int result = faqService.setUpdate(boardDTO, files);
		
		if(result > 0) {
			mv.setViewName("redirect:./faqList");
		} else {
			mv.addObject("msg", "수정 실패");
			mv.addObject("path", "./faqList");
			mv.setViewName("common/commonResult");
		}
		
		return mv;
	}
	
	@PostMapping("faqDelete")
	public ModelAndView setDelete(BoardDTO boardDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = faqService.setDelete(boardDTO);
		
		String message="삭제 실패";
		String path = "./faqList";
		
		if(result>0) {
			message="삭제 성공";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", path);
		
		mv.setViewName("common/commonResult");
		
		return mv;
	}
	
	@PostMapping("summerFileDelete")
	public ModelAndView setSummerFileDelete(String fileName)throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean result = faqService.setSummerFileDelete(fileName);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@PostMapping("summerFileUpload")
	public ModelAndView setSummerFileUpload(MultipartFile file)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("Summer File Upload");
		System.out.println(file.getOriginalFilename());
		String fileName = faqService.setSummerFileUpload(file);
		fileName = "../resources/upload/faq/"+fileName;
		mv.addObject("result", fileName);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@GetMapping("fileDelete")
	public ModelAndView setFileDelete(BoardFileDTO boardFileDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = faqService.setFileDelete(boardFileDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}

}
