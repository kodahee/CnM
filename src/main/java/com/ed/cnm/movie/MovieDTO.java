package com.ed.cnm.movie;

public class MovieDTO {
	private String movieCd;
	private String movieNm;//영화이름
	private String movieInfo;//시놉시스
	private String poster;
	private String rankNum;
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getMovieNm() {
		return movieNm;
	}
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}
	public String getRankNum() {
		return rankNum;
	}
	public void setRankNum(String rankNum) {
		this.rankNum = rankNum;
	}
	public String getMovieInfo() {
		return movieInfo;
	}
	public void setMovieInfo(String movieInfo) {
		this.movieInfo = movieInfo;
	}

	public String getMovieCd() {
		return movieCd;
	}
	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}
	
	
}
