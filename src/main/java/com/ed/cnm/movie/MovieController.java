package com.ed.cnm.movie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/movieDetail/**")
public class MovieController {

	@PostMapping("detailedInfo")
	public ModelAndView getDetailInfo(MovieDTO movieDTO ,ModelAndView mv)throws Exception{
		System.out.println("movieDetail Controller");
		System.out.println(movieDTO.getMovieCd());
		
		mv.addObject("dto", movieDTO);
		mv.setViewName("/movieDetail/infoBoard");
		return mv;
	}
}
