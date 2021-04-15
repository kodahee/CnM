package com.ed.cnm.ranking;

import org.springframework.stereotype.Component;

@Component
public class RankingDTO {
	private String rank;
	private String movieNm;
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public String getMovieNm() {
		return movieNm;
	}
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}
	
	
}
