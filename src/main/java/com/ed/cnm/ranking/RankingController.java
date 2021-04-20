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
	//===================예매율=====================
	@GetMapping("reservation")
	public ModelAndView getReservation(ModelAndView mv)throws Exception{
		System.out.println("--controller reservation");
		String url="https://movie.daum.net/ranking/reservation";
		Document doc = Jsoup.connect(url).get();
		Elements elements = doc.select("div.box_ranking ol li");
	
		//크롤링한 포스터이미지, 영화이름, 예매율 랭크, 시놉시스, 예매율 % 을 순차적으로 list에 담았다.
		List<RankingDTO> list = new ArrayList<RankingDTO>();
		for(Element el : elements) {
			RankingDTO rankingDTO = new RankingDTO();
			String poster = el.select("div.poster_movie img").attr("src");//""출력안됨
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
		mv.setViewName("/ranking/reservation");
		
		return mv;
	}
	
	//===================박스 오피스=====================
	@GetMapping("boxOffice/weekly")
	public ModelAndView getBoxOffice (ModelAndView mv, String date) throws Exception{
		//포스터 긁어오기
		System.out.println("--controller BOweekly");
		String url="https://movie.daum.net/ranking/boxoffice/weekly";
		if(date!=null) {
			url=url+"?="+date;
		}
		Document doc = Jsoup.connect(url).get();
		Elements elements = doc.select("ol.list_movieranking li");
		
		List<RankingDTO> list = new ArrayList<RankingDTO>();
		int i =0;
		for(Element el : elements) {
			RankingDTO rankingDTO = new RankingDTO();
			String poster = el.select("div.poster_movie img").attr("src");
			rankingDTO.setPoster(poster);
			i++;
			if(i==10) {
				break;
			}
		}
		mv.addObject("list", list);
		mv.addObject("boxOffice", "weekly");
		mv.setViewName("/ranking/boxOfficeBoard");
		
		return mv;
	}
	
	
	
}
