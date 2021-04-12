package com.ed.cnm.review;

import java.sql.Date;

public class ReviewDTO {
	private long reviewNum;
	private String nickName;
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
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
