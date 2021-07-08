package com.ed.cnm.booked;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ed.cnm.location.LocationTheaterDTO;
import com.ed.cnm.movie.MovieDTO;

@Controller
@RequestMapping("/booked/**")
public class BookedController {
	@Autowired
	private BookedService bookedService;
	
	@GetMapping("selectTime")
	public void selectTime(BookedDTO bookedDTO, Model model) throws Exception{
		MovieDTO movieDTO= bookedService.getSelect(bookedDTO);
		model.addAttribute("dto", movieDTO);
	}

	
//====
	@GetMapping("selectSeat")
	public void selectSeat(Model model,String poster, String movieTitle, LocationTheaterDTO locationTheaterDTO) throws Exception {
		model.addAttribute("poster", poster);
		model.addAttribute("movieTitle", movieTitle);
		model.addAttribute("dto", locationTheaterDTO);
	}
	
	@PostMapping("selectSeat")
	public void selectSeat(BookedDTO bookedDTO) throws Exception {
		System.out.println("Start");
		
		System.out.println("finish");
	}
	
	@GetMapping("payment")
	public void payments() throws Exception {

	}
}
