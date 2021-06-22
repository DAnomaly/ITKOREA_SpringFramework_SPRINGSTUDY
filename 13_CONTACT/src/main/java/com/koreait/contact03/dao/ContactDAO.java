package com.koreait.contact03.dao;

import java.util.List;

import com.koreait.contact03.dto.Contact;

public interface ContactDAO {

	public List<Contact> selectListContact();
	public Contact selectOneContact(long no);
	public int insertContact(Contact contact);
	public int updateContact(Contact contact);
	public int deleteContact(long no);
	
}
