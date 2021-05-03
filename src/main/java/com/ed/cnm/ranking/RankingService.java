package com.ed.cnm.ranking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankingService {
	
	@Autowired
	private RankingDAO rankingDAO;
	
	public int setInfo(RankingDTO rankingDTO)throws Exception{
		return rankingDAO.setInfo(rankingDTO);
	}
	public int setMovieCd(RankingDTO rankingDTO)throws Exception{
		return rankingDAO.setMovieCd(rankingDTO);
	}
	
	public RankingDTO getInfo(RankingDTO rankingDTO)throws Exception{
		return rankingDAO.getInfo(rankingDTO);
	}
	
	public long getCount(RankingDTO rankingDTO)throws Exception{
		return rankingDAO.getCount(rankingDTO);
	}
}
