package com.ed.cnm.board.community;

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
@RequestMapping("/community/**")
public class CommunityController {

	@Autowired
	private CommunityService communityService;
	
	@GetMapping("communityList")
	public ModelAndView getList(Pager pager, CommunityDTO communityDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = communityService.getList(pager);
		List<CommunityDTO> genreAr = communityService.getGenreList(communityDTO);
		
		mv.addObject("board", "community");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		mv.addObject("nav", "community");
		
		mv.addObject("genre", genreAr);
		
		return mv;
	}
	
	@GetMapping("communitySelect")
	public ModelAndView getSelect(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = communityService.getSelect(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "community");
		mv.setViewName("board/boardSelect");
		
		return mv;
	}
	
	@GetMapping("communityInsert")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "community");
		return mv;
	}
	
	@PostMapping("communityInsert")
	public String setInsert(CommunityDTO communityDTO, Model model, MultipartFile [] files) throws Exception {
		int result = communityService.setInsert(communityDTO, files);
		String message = "등록 실패";
		
		if(result > 0) {
			message="등록 성공";
		}
		
		model.addAttribute("msg", message);
		model.addAttribute("path", "./communityList");
		
		return "common/commonResult";
	}
	
	@GetMapping("communityUpdate")
	public ModelAndView setUpdate(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = communityService.getSelect(boardDTO);
		
		mv.addObject("dto", boardDTO);
		mv.addObject("board", "community");
		mv.setViewName("board/boardUpdate");
		
		return mv;
	}
	
	@PostMapping("communityUpdate")
	public ModelAndView setUpdate(CommunityDTO communityDTO, ModelAndView mv, MultipartFile [] files) throws Exception {
		int result = communityService.setUpdate(communityDTO, files);
		
		if(result > 0) {
			mv.setViewName("redirect:./communitySelect");
		} else {
			mv.addObject("msg", "수정 실패");
			mv.addObject("path", "./communitySelect");
			mv.setViewName("common/commonResult");
		}
		
		return mv;
	}
	
	@PostMapping("communityDelete")
	public ModelAndView setDelete(CommunityDTO communityDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = communityService.setDelete(communityDTO);
		
		String message = "삭제 실패";
		String path = "./communityList";
		
		if(result > 0) {
			message = "삭제 성공";
		}
		
		mv.addObject("msg", message);
		mv.addObject("path", path);
		mv.setViewName("common/commonResult");
		
		return mv;
	}

	@PostMapping("summerFileUpload")
	public ModelAndView setSummerFileUpload(MultipartFile file)throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("Summer File Upload");
		System.out.println(file.getOriginalFilename());
		String fileName = communityService.setSummerFileUpload(file);
		fileName = "../resources/upload/community/"+fileName;
		mv.addObject("result", fileName);
		mv.setViewName("common/ajaxResult");
		
		return mv;
	}
	
	@PostMapping("summerFileDelete")
	public ModelAndView setSummerFileDelete(String fileName)throws Exception{
		ModelAndView mv = new ModelAndView();
		boolean result = communityService.setSummerFileDelete(fileName);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@GetMapping("fileDelete")
	public ModelAndView setFileDelete(BoardFileDTO boardFileDTO)throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = communityService.setFileDelete(boardFileDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
}