package com.ed.cnm.booked;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/booked/**")
public class BookedController {

	@GetMapping("selectSeat")
	public void selectSeat() throws Exception {

	}
	
	@PostMapping("selectSeat")
	public void selectSeat(BookedDTO bookedDO) throws Exception {
		System.out.println("Start");
		
		System.out.println("finish");
	}
	
}
