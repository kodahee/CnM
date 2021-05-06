package com.ed.cnm.movieInfo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ed.cnm.ranking.RankingDTO;
import com.ed.cnm.util.WebCrawlering;


@Controller
@RequestMapping("/movieDetail/**")
public class MovieInfoController {
	@Autowired
	private MovieInfoService movieInfoService;

	@GetMapping("infoBoard")
	public ModelAndView getDetailInfo(MovieInfoDTO movieInfoDTO ,ModelAndView mv)throws Exception{
		System.out.println("movieDetail Controller");
		movieInfoDTO = movieInfoService.getInfo(movieInfoDTO);
		
		WebCrawlering crawlering = new WebCrawlering();
		RankingDTO rankingDTO = new RankingDTO();
		List<RankingDTO> list = crawlering.getCrawlering("https://movie.daum.net/ranking/boxoffice/weekly");
		List<MovieInfoDTO> list2 = new ArrayList<MovieInfoDTO>();
		for(int i = 0 ;i<7; i++) {
			MovieInfoDTO infoDTO = new MovieInfoDTO(); 
			rankingDTO =  list.get(i);
			infoDTO.setPoster(rankingDTO.getPoster());
			String name = rankingDTO.getMovieNm();
			infoDTO.setMovieNm(name);
			MovieInfoDTO cd = movieInfoService.getCd(infoDTO);
			System.out.println(cd.getMovieCd());
			if(cd.getMovieCd() != null) {
				infoDTO.setMovieCd(cd.getMovieCd()); 
			}else {
				System.out.println("no");
			}
			list2.add(infoDTO);
		}
		
		mv.addObject("list", list2);
		mv.addObject("dto", movieInfoDTO);
		mv.setViewName("/movieDetail/infoBoard");
		return mv;
	}
}
