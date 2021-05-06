package com.ed.cnm.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.ed.cnm.ranking.RankingDTO;

public class WebCrawlering {
	public List<RankingDTO> getCrawlering(String url) throws Exception{

		//디폴트로 작업하던거 if말고 있었던 거 같은데 알아보기
		Document doc = Jsoup.connect(url).get();
		Elements elements = doc.select("ol.list_movieranking li");
		
		List<RankingDTO> list = new ArrayList<RankingDTO>();
		int i =0;
		for(Element el : elements) {
			RankingDTO rankingDTO = new RankingDTO();
			String poster = el.select("div.poster_movie img").attr("src");
			String movieNm = el.select("div.poster_movie img").attr("alt");
			String movieInfo = el.select("div.poster_info a.link_story").text();
			rankingDTO.setPoster(poster);
			rankingDTO.setMovieNm(movieNm);;//pk키 느낌으로 
			rankingDTO.setMovieInfo(movieInfo);
			list.add(rankingDTO);
			i++;
			if(i==10) {
				break;
			}
		}
		return list;
	}
	
	
	
}


