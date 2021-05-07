package com.ed.cnm.location;

import java.sql.Date;

public class LocationTheaterDTO {
	private long num;
	private long theaterNum;
	private String room;
	private String totalSeat;
	private String movieType;
	private String scheduleDate;
	private String scheduleTime;
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public long getTheaterNum() {
		return theaterNum;
	}
	public void setTheaterNum(long theaterNum) {
		this.theaterNum = theaterNum;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(String totalSeat) {
		this.totalSeat = totalSeat;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	
	public String getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	
	
}
