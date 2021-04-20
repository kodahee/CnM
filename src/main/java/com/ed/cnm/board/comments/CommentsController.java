package com.ed.cnm.board.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/comments/**")
public class CommentsController {
	
	@Autowired
	private CommentsService commentsService;

	@PostMapping("commentsDelete")
	public void commentsDelete(int [] commentsNum) throws Exception {
		System.out.println("Start");
		
		System.out.println("finish");
	}
	
	@PostMapping("commentsInsert")
	public ModelAndView setInsert(CommentsDTO commentsDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = commentsService.setInsert(commentsDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@GetMapping("commentsList")
	public void getList(CommentsDTO commentsDTO, Model model) throws Exception {
		System.out.println(commentsDTO.getNum());
		List<CommentsDTO> ar = commentsService.getList(commentsDTO);
		model.addAttribute("list", ar);
	}
}
