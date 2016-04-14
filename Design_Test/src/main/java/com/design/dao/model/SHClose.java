package com.design.dao.model;

import java.sql.Date;

public class SHClose {

	private int id;
	private Date date;
	private float value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public SHClose() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "SHClose [id=" + id + ", date=" + date + ", value=" + value
				+ "]";
	}

}
