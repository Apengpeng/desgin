package com.design.service.model;

public class AuthorVO {

	private String author;

	private int count;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AuthorVO [author=" + author + ", count=" + count + "]";
	}

	

}
