package com.koreait.mvc02.dto;

public class Member {

	// field
	private String id;
	private Contact contact;
	
	// constructor
	public Member() {}
	public Member(String id, Contact contact) {
		this.id = id;
		this.contact = contact;
	}
	
	// getter/setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
}
