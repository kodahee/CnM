package com.ed.cnm.location;

public class LocationDTO {
	private long num;
	private String theater;
	private String room;
	private String seatName;
	private String movieType;
	private long totalProfit;
	private long totalAudience;
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
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
	public long getTotalProfit() {
		return totalProfit;
	}
	public void setTotalProfit(long totalProfit) {
		this.totalProfit = totalProfit;
	}
	public long getTotalAudience() {
		return totalAudience;
	}
	public void setTotalAudience(long totalAudience) {
		this.totalAudience = totalAudience;
	}
	
	
}
