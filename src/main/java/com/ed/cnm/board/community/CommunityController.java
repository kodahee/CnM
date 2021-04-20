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
import com.ed.cnm.util.Pager;

@Controller
@RequestMapping("/community/**")
public class CommunityController {

	@Autowired
	private CommunityService communityService;
	
	@GetMapping("communityInsert")
	public ModelAndView setInsert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/boardInsert");
		mv.addObject("board", "notice");
		return mv;
	}
	
	@PostMapping("communityInsert")
	public String setInsert(CommunityDTO communityDTO, Model model, MultipartFile [] files) throws Exception {
		int result = communityService.setInsert(communityDTO, files);
		String message = "등록 실패";
		
		if(result > 0) {
			message="등록 성공";
		}
		
		model.addAttribute("msa", message);
		model.addAttribute("path", "./communityList");
		
		return "common/commonResult";
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
	
	@GetMapping("communityList")
	public ModelAndView getList(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = communityService.getList(pager);
		
		mv.addObject("board", "community");
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/boardList");
		
		return mv;
	}
	
}
