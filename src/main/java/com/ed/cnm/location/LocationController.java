package com.ed.cnm.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/location/**")
public class LocationController {
	@Autowired
	private LocationService locationService;
	
	/*
	 * @GetMapping("locationTheater") public String getSelect(LocationDTO
	 * theaterNum)throws Exception{ System.out.println("location");
	 * 
	 * String location=locationService.getSelect(theaterNum).getRegion();
	 * 
	 * return "redirect: ../locationTheater/"+location; }
	 */
}
