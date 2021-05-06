package com.ed.cnm.ranking;

import com.ed.cnm.movie.MovieDTO;

public class RankingDTO extends MovieDTO{
	
	private String rankNum;
	private String reservation;//예약 예매율
	
	
	public String getRankNum() {
		return rankNum;
	}
	public void setRankNum(String rankNum) {
		this.rankNum = rankNum;
	}
	
	public String getReservation() {
		return reservation;
	}
	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	
	
}
