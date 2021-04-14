package com.ed.cnm.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import oracle.jdbc.proxy.annotation.Post;

@Controller
@RequestMapping("/ranking/**")
public class RankingController {
	
	@Autowired
	private RankingService rankingService;

	@GetMapping("bookingRanking")
	public void getRanking(String [] result)throws Exception{
		System.out.println("controller--");
		rankingService.getRanking(result);
	}
	
	
	
}
