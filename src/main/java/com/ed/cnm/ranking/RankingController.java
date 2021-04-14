package com.ed.cnm.ranking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/ranking/**")
public class RankingController {
	
	@Autowired
	private RankingService rankingService;

	@GetMapping("bookingRanking")
	public void getRanking()throws Exception{
		System.out.println("--controller");
		
	}
	
	@PostMapping("bookingRanking")
	public void getRanking(String result)throws Exception{
	
//		resultMap = JSONArray.fromObject(result);
//		System.out.println(result);
//		//rankingService.getRanking(result);
		System.out.println("controller--");
//		
	}
	
	
	
}
