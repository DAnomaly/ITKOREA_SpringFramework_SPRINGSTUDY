package com.koreait.contact02.command;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import com.koreait.contact02.dao.ContactDAO;
import com.koreait.contact02.dto.Contact;

@Component
public class SelectListContactCommand implements ContactCommand {

	@Autowired
	ContactDAO dao;
	
	@Override
	public boolean execute(Model model) {
		
		List<Contact> list = dao.selectListContact(); 
		model.addAttribute("list",list);
		
		return true;
	}

}
