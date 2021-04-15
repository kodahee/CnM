package com.ed.cnm.ranking;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/ranking/**")
public class RankingController {

	
	@RequestMapping(value="bookingRanking", method={RequestMethod.GET , RequestMethod.POST})
	public void getRanking()throws Exception{
		System.out.println("controller");
		
	}
	
	
	
	
}
