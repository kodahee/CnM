package com.ed.cnm.ranking;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/ranking/**")
public class BookingRankingController {
	@GetMapping("bookingRanking")
	public void getRanking()throws Exception{
		System.out.println("--controller");
		String url="https://movie.daum.net/ranking/reservation";
		Document doc = Jsoup.connect(url).get();
		Elements elements = doc.select("div.box_ranking ol");
		//System.out.println(elements.toString());
		for(Element el : elements) {
			System.out.println(el.toString());
			System.out.println("==");
			System.out.println(el.text());
		}
	}
	
	
//	@PostMapping("bookingRanking")
//	public void getRanking(String CSRFToken, Model model)throws Exception{
//		System.out.println("controller--");
//		String url="https://www.kobis.or.kr/kobis/business/stat/boxs/findRealTicketList.do";
//
//		Document doc = Jsoup.connect(url).data("CSRFToken", CSRFToken).post();//HTML부터 데이터 가져오기
//		//System.out.println(doc.toString());제대로 가져와짐
//		Elements element = doc.select("div.rst_sch");
//		Elements element2 = doc.select("div.rst_sch tbody");
//		//Elements elem = element.select("tbody");
//	
//		for(Element el : element2.select("td")) {
//			System.out.println(el.toString());
//			System.out.println("==");
//		
//	}
	
	
	
	
}
