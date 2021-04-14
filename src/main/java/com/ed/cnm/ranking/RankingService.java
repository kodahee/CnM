package com.ed.cnm.ranking;

import org.springframework.stereotype.Service;

@Service
public class RankingService {
	
	
	public void getRanking(String [] result)throws Exception{
		System.out.println("--service");
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	
}
