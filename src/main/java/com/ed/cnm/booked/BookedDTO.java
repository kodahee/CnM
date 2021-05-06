package com.ed.cnm.booked;

import java.sql.Date;

public class BookedDTO {
	private String bookedCode;
	private String id;
	private String movieTitle;
	private String region;
	private String room;
	private long adult;
	private long kid;
	private String seatName;
	private long price;
	private String payment;
	private String state;
	
	private String movieCd;
	
	public String getMovieCd() {
		return movieCd;
	}
	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}
	public String getBookedCode() {
		return bookedCode;
	}
	public void setBookedCode(String bookedCode) {
		this.bookedCode = bookedCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public long getAdult() {
		return adult;
	}
	public void setAdult(long adult) {
		this.adult = adult;
	}
	public long getKid() {
		return kid;
	}
	public void setKid(long kid) {
		this.kid = kid;
	}
	public String getSeatName() {
		return seatName;
	}
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
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