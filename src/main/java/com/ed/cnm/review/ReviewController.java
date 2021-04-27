package com.ed.cnm.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ranking/**")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("review")
	public void getList(ReviewDTO reviewDTO, Model model) throws Exception {
		System.out.println(reviewDTO.getMovieTitle());
		List<ReviewDTO> ar = reviewService.getList(reviewDTO);
		model.addAttribute("list", ar);
	}

	@PostMapping("reviewInsert")
	public void setIsnert(ReviewDTO reviewDTO) throws Exception {
		int result = reviewService.setInsert(reviewDTO);
	}
	
	@PostMapping("reviewDelete")
	public void reviewDelete(ReviewDTO reviewDTO) throws Exception {
		System.out.println("Start");
		
		System.out.println("finish");
	}
	
	@PostMapping("reviewUpdate")
	public void reviewUpdate(ReviewDTO reviewDTO) throws Exception {
		System.out.println("Start");
		
		System.out.println("finish");
	}

}