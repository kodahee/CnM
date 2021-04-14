package com.ed.cnm.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingService {
	
	@Autowired
	private RankingDAO rankingDAO;
	
	public void getRanking(String [] result)throws Exception{
		System.out.println("--service");
		for(int i=0; i<result.length; i++) {
			rankingDAO.getRanking(result[i]);
		}
	}
	
	
}
