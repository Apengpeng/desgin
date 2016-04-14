package com.design.service.model;

import java.sql.Date;

public class MoodVO {

	private Date date;
	private float moodValue;

	private float moodValueChange;

	private float shcloseValue;

	private float shcloseValueChange;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getMoodValue() {
		return moodValue;
	}

	public void setMoodValue(float moodValue) {
		this.moodValue = moodValue;
	}

	public float getMoodValueChange() {
		return moodValueChange;
	}

	public void setMoodValueChange(float moodValueChange) {
		this.moodValueChange = moodValueChange;
	}

	public float getShcloseValue() {
		return shcloseValue;
	}

	public void setShcloseValue(float shcloseValue) {
		this.shcloseValue = shcloseValue;
	}

	public float getShcloseValueChange() {
		return shcloseValueChange;
	}

	public void setShcloseValueChange(float shcloseValueChange) {
		this.shcloseValueChange = shcloseValueChange;
	}

	@Override
	public String toString() {
		return "MoodVO [date=" + date + ", moodValue=" + moodValue
				+ ", moodValueChange=" + moodValueChange + ", shcloseValue="
				+ shcloseValue + ", shcloseValueChange=" + shcloseValueChange
				+ "]";
	}

}
