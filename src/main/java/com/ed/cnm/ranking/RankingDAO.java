package com.ed.cnm.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RankingDAO {
	@Autowired
	private RankingDTO rankingDTO;
	
	public void getRanking(String result)throws Exception{
		
		System.out.println("--DAO");
		System.out.println(result);
		rankingDTO.setDailyBoxOfficeList(result);
		System.out.println(rankingDTO.getDailyBoxOfficeList()+"print");
	
		
	
	}
}
