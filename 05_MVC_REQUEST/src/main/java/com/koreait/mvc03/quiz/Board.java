package com.koreait.mvc03.quiz;

import java.util.Date;

public class Board {
	private String title;
	private int hit;
	private Date date;
	
	public Board() {}
	public Board(String title, int hit, Date date) {
		super();
		this.title = title;
		this.hit = hit;
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
