package com.ed.cnm.ranking;

import org.springframework.stereotype.Component;

@Component
public class RankingDTO {
	
	private String dailyBoxOfficeList;

	public String getDailyBoxOfficeList() {
		return dailyBoxOfficeList;
	}

	public void setDailyBoxOfficeList(String dailyBoxOfficeList) {
		this.dailyBoxOfficeList = dailyBoxOfficeList;
	}
	
	
}
