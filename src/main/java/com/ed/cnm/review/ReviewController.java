package com.ed.cnm.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ranking/**")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping("review")
	public void setInsert() throws Exception {

	}
	
	@PostMapping("review")
	public void setInsert(ReviewDTO reviewDTO) throws Exception {
		int result = reviewService.setInsert(reviewDTO);
	}

}
