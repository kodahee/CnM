package com.ed.cnm.location.seoul;

import java.util.ArrayList;
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
	public ModelAndView getList(LocationTheaterDTO theaterDTO, ModelAndView mv)throws Exception{
		System.out.println("seoul");
		List<LocationTheaterDTO> list =Service.getList(theaterDTO);
		List<LocationTheaterDTO> ar = new ArrayList<LocationTheaterDTO>();
		for(LocationTheaterDTO index: list) {
			if(index.getScheduleDate()==theaterDTO.getScheduleDate()) {
				ar.add(theaterDTO);
			};
		}
		
		mv.addObject("list", ar);
		mv.setViewName("/booked/selectTimeBoard");
		return mv;
	}
}
