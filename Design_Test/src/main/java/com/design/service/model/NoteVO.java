package com.design.service.model;

import java.sql.Date;

public class NoteVO {
	private  int id;
	private Date date;
	private String title;
	private String author;
	private int reading;
	private int comments;
	private float moodValue;
	private String link;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public float getReading() {
		return reading;
	}

	
	public int getComments() {
		return comments;
	}

	public void setComments(int comments) {
		this.comments = comments;
	}

	public float getMoodValue() {
		return moodValue;
	}

	public void setMoodValue(float f) {
		this.moodValue = f;
	}

	public void setReading(int reading) {
		this.reading = reading;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "NoteVO [id=" + id + ", date=" + date + ", title=" + title
				+ ", author=" + author + ", reading=" + reading + ", comments="
				+ comments + ", moodValue=" + moodValue + ", link=" + link
				+ "]";
	}

}
