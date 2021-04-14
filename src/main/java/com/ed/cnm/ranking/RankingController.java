package com.ed.cnm.ranking;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ranking/**")
public class RankingController {

	@GetMapping("bookingRanking")
	public void getRanking(String result)throws Exception{
		System.out.println(result);
	}
	
}
