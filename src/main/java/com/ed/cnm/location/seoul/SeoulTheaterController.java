package com.ed.cnm.location.seoul;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ed.cnm.location.LocationTheaterDTO;

@Controller
@RequestMapping("/locationTheater/**")
public class SeoulTheaterController {
	
	@Autowired
	private SeoulTheaterService Service;
	
	@GetMapping("seoul")
	public ModelAndView getList(ModelAndView mv, LocationTheaterDTO theaterDTO )throws Exception{
		System.out.println("seoul");
	
		List<LocationTheaterDTO> list =Service.getList(theaterDTO);
		
		
		mv.addObject("list", list);
		mv.setViewName("/booked/selectTimeBoard");
		return mv;
	}
}
