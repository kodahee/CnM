package com.ed.cnm.review;

import java.sql.Date;

public class ReviewDTO {
	private long reviewNum;
	private String id;
	private String nickName;
	private String movieTitle;
	private double star;
	private String contents;
	private Date regDate;
	private long goodNum;
	private long badNum;
	private long warning;


	public long getReviewNum() {
		return reviewNum;
	}
	public void setReviewNum(long reviewNum) {
		this.reviewNum = reviewNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public double getStar() {
		return star;
	}
	public void setStar(double star) {
		this.star = star;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public long getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(long goodNum) {
		this.goodNum = goodNum;
	}
	public long getBadNum() {
		return badNum;
	}
	public void setBadNum(long badNum) {
		this.badNum = badNum;
	}
	public long getWarning() {
		return warning;
	}
	public void setWarning(long warning) {
		this.warning = warning;
	}

}
