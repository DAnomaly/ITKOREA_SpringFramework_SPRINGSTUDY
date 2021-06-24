package com.koreait.member.dto;

import java.sql.Date;

public class Member {

	private long no;
	private String id;
	private String pw;
	private String name;
	private String email;
	private Date date;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", pw=" + pw + ", name=" + name + ", email=" + email + ", date="
				+ date + "]";
	}
	
}
