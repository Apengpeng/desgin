package com.design.service.model;

import java.sql.Date;

public class TNoteVO{

	private Date date;

	private int reading;
	private int comments;
	private int create;
	
	private float moodvalue;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getReading() {
		return reading;
	}

	public void setReading(int reading) {
		this.reading = reading;
	}

	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public int getCreate() {
		return create;
	}

	public void setCreate(int create) {
		this.create = create;
	}

	public float getMoodvalue() {
		return moodvalue;
	}

	public void setMoodvalue(float moodvalue) {
		this.moodvalue = moodvalue;
	}

	@Override
	public String toString() {
		return "TNoteVO [date=" + date + ", reading=" + reading + ", comments="
				+ comments + ", create=" + create + ", moodvalue=" + moodvalue
				+ "]";
	}

}
