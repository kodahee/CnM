package com.ed.cnm.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingService {
	
	@Autowired
	private RankingDAO rankingDAO;
	
	public RankingDTO getRanking(RankingDTO [] whole)throws Exception{
		
		for(RankingDTO dto: whole) {
			RankingDTO rankingDTO = new RankingDTO();
			rankingDTO.setRank(dto.getRank());
			rankingDTO.setMovieNm(dto.getMovieNm());
		}
		
		return null;
	}
	
}
