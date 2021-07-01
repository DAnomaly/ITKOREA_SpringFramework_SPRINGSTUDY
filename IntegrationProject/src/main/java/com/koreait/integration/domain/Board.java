package com.koreait.integration.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Board {

	private long no;
	private String writer;
	private String title;
	private String content;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date postdate;
	
	public Board() {}
	public Board(long no, String writer, String title, String content, Date postdate) {
		this.no = no;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.postdate = postdate;
	}
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	
}
