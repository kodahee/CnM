package com.ed.cnm.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/ranking/**")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("review")
	public void getList(ReviewDTO reviewDTO, Model model) throws Exception {
		reviewDTO.setMovieTitle("movie1");
		System.out.println(reviewDTO.getMovieTitle());
		List<ReviewDTO> ar = reviewService.getList(reviewDTO);
		model.addAttribute("list", ar);
	}

	@PostMapping("reviewInsert")
	public ModelAndView setInsert(ReviewDTO reviewDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		reviewDTO.setMovieTitle("movie1");
		int result = reviewService.setInsert(reviewDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	
	@PostMapping("reviewDelete")
	public ModelAndView setDelete(ReviewDTO reviewDTO) throws Exception {
		System.out.println("delete");
		ModelAndView mv = new ModelAndView();
		int result = reviewService.setDelete(reviewDTO);
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
	

}