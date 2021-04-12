package com.ed.cnm.schedule;

import java.sql.Date;

public class ScheduleDTO {
	private long scheduleNum;
	private String theater;
	private String room;
	private String movieType;
	private Date scheduleTile;
	private String movieTitle;
	public long getScheduleNum() {
		return scheduleNum;
	}
	public void setScheduleNum(long scheduleNum) {
		this.scheduleNum = scheduleNum;
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
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	public Date getScheduleTile() {
		return scheduleTile;
	}
	public void setScheduleTile(Date scheduleTile) {
		this.scheduleTile = scheduleTile;
	}
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	
	
}
