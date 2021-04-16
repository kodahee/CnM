package com.ed.cnm.ranking;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
@RequestMapping("/ranking/**")
public class RankingController {

	
	@GetMapping("bookingRanking")
	public void getRanking(Model model)throws Exception{
		System.out.println("controller");
		String url="https://www.kobis.or.kr/kobis/business/stat/boxs/findRealTicketList.do";

		Document doc = Jsoup.connect(url).get();//HTML부터 데이터 가져오기
		//System.out.println(doc.toString());제대로 가져와짐
		Elements element = doc.select("div.rst_sch");
		Elements element2 = doc.select("div.rst_sch tbody");
		//Elements elem = element.select("tbody");
	
		for(Element el : element2.select("td")) {
			System.out.println(el.toString());
			System.out.println("==");
		}
//		
//		System.out.println(element2);
//		System.out.println("=======================");
//		
//		System.out.println(element2.text());
//		
		
		
		/*
<div class="rst_sch"> 
 <div class="hd_rst"> 
  <span class="total">총 <em class="fwb">0</em>건 </span> 
  <span style="display: inline-block;float: right;margin-top:17px;"><em><b>조회일시 : 2021/04/16 12:23</b></em></span> 
 </div> 
 <table class="tbl_comm th_sort"> 
  <caption class="blind">
   검색 결과
  </caption> 
  <colgroup> 
   <col style="width:5%"> 
   <col style="width:25%"> 
   <col style="width:8%"> 
   <col style="width:11%"> 
   <col style="width:8%"> 
   <col style="width:11%"> 
   <col style="width:7%"> 
   <col style="width:9%"> 
  </colgroup> 
  <thead> 
   <tr> 
    <th scope="col">순위</th> 
    <th scope="col">영화명</th> 
    <th scope="col">개봉일</th> 
    <th scope="col"> 예매율 <span class="btn_updwBox"> <button name="btn_up" type="button" class="btn_up01"> <span>오름차순</span> </button> <button name="btn_dw" type="button" class="btn_dw02"> <span>내림차순</span> </button> </span> </th> 
    <th scope="col"> 예매매출액 <span class="btn_updwBox"> <button name="btn_up" type="button" class="btn_up01"> <span>오름차순</span> </button> <button name="btn_dw" type="button" class="btn_dw01"> <span>내림차순</span> </button> </span> </th> 
    <th scope="col"> 누적매출액 <span class="btn_updwBox"> <button name="btn_up" type="button" class="btn_up01"> <span>오름차순</span> </button> <button name="btn_dw" type="button" class="btn_dw01"> <span>내림차순</span> </button> </span> </th> 
    <th scope="col"> 예매관객수 <span class="btn_updwBox"> <button name="btn_up" type="button" class="btn_up01"> <span>오름차순</span> </button> <button name="btn_dw" type="button" class="btn_dw01"> <span>내림차순</span> </button> </span> </th> 
    <th scope="col"> 누적관객수 <span class="btn_updwBox"> <button name="btn_up" type="button" class="btn_up01"> <span>오름차순</span> </button> <button name="btn_dw" type="button" class="btn_dw01"> <span>내림차순</span> </button> </span> </th> 
   </tr> 
  </thead> 
  <tbody> 
   <tr>
    <td colspan="8">검색된 데이터가 존재하지 않습니다.</td>
   </tr> 
  </tbody> 
 </table> 
 <div class="tar marginT7"> 
  <span class="total fl">총 <em class="fwb">0</em>건</span> 
  <a href="javascript:;" class="btn_small" onclick="chkform('excel'); return false;">엑셀</a> 
 </div> 
</div>
*/
		
	}
	
	
	
	
}
