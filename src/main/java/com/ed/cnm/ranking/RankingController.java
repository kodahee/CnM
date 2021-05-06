package com.ed.cnm.ranking;


import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.ed.cnm.util.WebCrawlering;

import oracle.jdbc.proxy.annotation.Post;




@Controller
@RequestMapping("/ranking/**")
public class RankingController {
	
	@Autowired
	private RankingService rankingService;
	
	//===================예매율=====================
	@GetMapping("reservation")
	public ModelAndView getReservation(ModelAndView mv)throws Exception{
		System.out.println("--controller reservation");
		String url="https://movie.daum.net/ranking/reservation";
		Document doc = Jsoup.connect(url).get();
		Elements elements = doc.select("div.box_ranking ol li");
	
		//크롤링한 포스터이미지, 영화이름, 예매율 랭크, 시놉시스, 예매율 % 을 순차적으로 list에 담았다.
		//시놉시스 영화이름 포스터이미지 데이터베이스에 넣었음 
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
			//DB저장 Cd없음 중복 방지를 위한 코드 필요
			long result = rankingService.getCount(rankingDTO);
			if(result<1) {
				rankingService.setInfo(rankingDTO);
			}
			list.add(rankingDTO);
		}
		mv.addObject("list", list);
		mv.addObject("nav","ranking");
		mv.setViewName("/ranking/reservation");
		
		return mv;
	}
	//=========Cd DB에 담는 용도=============
	@PostMapping("reservation")
	public void setMovieCd(RankingDTO rankingDTO)throws Exception{
		int result=rankingService.setMovieCd(rankingDTO);
		
	}
	
	
	
	//===================박스 오피스=====================
	@GetMapping("boxOffice")
	public ModelAndView getBoxOffice (WebCrawlering webCrawlering, ModelAndView mv, Date date) throws Exception{
		
		System.out.println("--controller BOweekly");
		String url="https://movie.daum.net/ranking/boxoffice/weekly";
		
		List<RankingDTO> list = webCrawlering.getCrawlering(url);
		//포스터랑 시놉시스, 이름(pk용으로 쓸 수 있을까 해서,,)
		
		for(RankingDTO rankingDTO : list) {
			long result = rankingService.getCount(rankingDTO);
			if(result<1) {
				rankingService.setInfo(rankingDTO);
			}
			
		}
		
		
		
		mv.addObject("list", list);
		mv.addObject("nav","ranking");
		mv.addObject("ranking", "boxOffice");
		mv.setViewName("/ranking/boxOfficeBoard");
		
		return mv;
	}
	
	@PostMapping("boxOffice")
	public void setMovieCds(RankingDTO rankingDTO)throws Exception{
		int result=rankingService.setMovieCd(rankingDTO);
		System.out.println(result);
	}
	
	//===========리스트(ajax)==================
	@GetMapping("boxOffice/list")
	public ModelAndView getPosterInfo(WebCrawlering webCrawlering, ModelAndView mv, Date date)throws Exception{
		
		//Date date 를 YYYYmmdd로 바꾸기
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
					
		String result = sd.format(date);
		System.out.println(""+result);

		String url="https://movie.daum.net/ranking/boxoffice/weekly?date="+result;
		List<RankingDTO> list =webCrawlering.getCrawlering(url);
		
		mv.addObject("list", list);
		mv.setViewName("/ranking/boxOfficeResult");
		
		return mv;
	}
	

	
}
