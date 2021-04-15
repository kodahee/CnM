package com.ed.cnm.ranking;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



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
	public void getRanking(RankingDTO [] rankingDTO)throws Exception{
		
	System.out.println(rankingDTO[0].getRank());
		
		
		
		System.out.println("controller--");

	}
	
	
	
}
