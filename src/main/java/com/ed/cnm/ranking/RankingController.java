package com.ed.cnm.ranking;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


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
	public void getRanking(String [] result)throws Exception{
//		System.out.println(result);
//		int count = result.length;
//		byte [] src = new byte[count];
//		ObjectMapper mapper = new ObjectMapper();
//		Map<String, String> map = mapper.readValue(src, new TypeReference<Map<String,String>>() {});
//		String a =map.get("rank");
//		System.out.println(a);
		
		//com.fasterxml.jackson.core.JsonParseException: Illegal character ((CTRL-CHAR, code 0)): only regular white space (\r, \n, \t) is allowed between tokens
		// at [Source: (byte[])"
		
		System.out.println("controller--");

	}
	
	
	
}
