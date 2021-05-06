package com.ed.cnm.location;

import java.sql.Date;

public class LocationTheaterDTO {
	private long num;
	private long theaterNum;
	private String room;
	private String totalSeat;
	private String movieType;
	private Date scheduleDate;
	private Date scheduleTime;
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
	public Date getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public Date getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(Date scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	
	
}
