package com.design.dao.model;

import java.sql.Date;

public class Title {
	
	private int id;
	private String title;
	private Date publish_date;
	private Date lastupdate_date;
	private String author;
	private int reading;
	private int comment;

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

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public Date getLastupdate_date() {
		return lastupdate_date;
	}

	public void setLastupdate_date(Date lastupdate_date) {
		this.lastupdate_date = lastupdate_date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getReading() {
		return reading;
	}

	public void setReading(int reading) {
		this.reading = reading;
	}

	public int getComment() {
		return comment;
	}

	public void setComment(int comment) {
		this.comment = comment;
	}

	public Title() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Title [id=" + id + ", title=" + title + ", publish_date="
				+ publish_date + ", lastupdate_date=" + lastupdate_date
				+ ", author=" + author + ", reading=" + reading + ", comment="
				+ comment + "]";
	}
}
