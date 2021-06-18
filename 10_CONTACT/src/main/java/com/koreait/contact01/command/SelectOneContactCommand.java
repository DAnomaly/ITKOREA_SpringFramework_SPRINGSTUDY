package com.koreait.contact01.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.contact01.dao.ContactDAO;
import com.koreait.contact01.dto.Contact;

@Component
public class SelectOneContactCommand implements ContactCommand {

	@Autowired
	ContactDAO dao;
	
	@Override
	public boolean execute(Model model) {
		
		long no = (Long)model.asMap().get("no");
		Contact contact = dao.selectOneContact(no);
		if(contact == null) {
			return false;
		} else {
			model.addAttribute("contact", contact);
			return true;
		}
	}
	
}
