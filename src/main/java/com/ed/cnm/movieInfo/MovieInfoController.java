package com.ed.cnm.movieInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/movieDetail/**")
public class MovieInfoController {
	@Autowired
	private MovieInfoService movieInfoService;

	@GetMapping("infoBoard")
	public ModelAndView getDetailInfo(MovieInfoDTO movieInfoDTO ,ModelAndView mv)throws Exception{
		System.out.println("movieDetail Controller");
		movieInfoDTO = movieInfoService.getInfo(movieInfoDTO);
		
		mv.addObject("dto", movieInfoDTO);
		mv.setViewName("/movieDetail/infoBoard");
		return mv;
	}
}
