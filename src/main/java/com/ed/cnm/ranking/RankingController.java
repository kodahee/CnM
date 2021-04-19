package com.ed.cnm.ranking;


import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/ranking/**")
public class RankingController {
	
	@GetMapping("reservation")
	public ModelAndView getRanking(ModelAndView mv)throws Exception{
		System.out.println("--controller");
		String url="https://movie.daum.net/ranking/reservation";
		Document doc = Jsoup.connect(url).get();
		Elements elements = doc.select("div.box_ranking ol li");
	
		//크롤링한 포스터이미지, 영화이름, 예매율 랭크, 시놉시스, 예매율 % 을 순차적으로 list에 담았다.
		List<RankingDTO> list = new ArrayList<RankingDTO>();
		for(Element el : elements) {
			RankingDTO rankingDTO = new RankingDTO();
			String poster = el.select("div.poster_movie img").attr("src");//""까지 출력안됨
			String movieNm = el.select("div.poster_movie img").attr("alt");
			String rankNum = el.select("div.poster_movie span.rank_num").text();
			String movieInfo = el.select("div.poster_info a.link_story").text();
			String reservation = el.select("span.info_txt span.txt_num").text();
			rankingDTO.setPoster(poster);
			rankingDTO.setMovieNm(movieNm);
			rankingDTO.setRankNum(rankNum);
			rankingDTO.setMovieInfo(movieInfo);
			rankingDTO.setReservation(reservation);
			list.add(rankingDTO);
		}
		mv.addObject("list", list);
		mv.addObject("ranking", "reservation");
		mv.setViewName("/ranking/rankingBoard");
		return mv;
	}
	
	
	
	
}