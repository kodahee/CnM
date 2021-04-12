package com.ed.cnm.booked;

import java.sql.Date;

public class BookedDTO {
	private String bookedCode;
	private String nickName;
	private String theater;
	private String room;
	private String seatName;
	private String movieType;
	private String movieTitle;
	private Date scheduleTime;
	private long price;
	private long bookedNum;
	private String payment;
	private String state;
	public String getBookedCode() {
		return bookedCode;
	}
	public void setBookedCode(String bookedCode) {
		this.bookedCode = bookedCode;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTheater() {
		return theater;
	}
	public void setTheater(String theater) {
		this.theater = theater;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public Date getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getBookedNum() {
		return bookedNum;
	}
	public void setBookedNum(long bookedNum) {
		this.bookedNum = bookedNum;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
