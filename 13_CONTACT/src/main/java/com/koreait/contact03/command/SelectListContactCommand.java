package com.koreait.contact03.command;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.contact03.dao.ContactDAO;
import com.koreait.contact03.dto.Contact;

public class SelectListContactCommand implements ContactCommand {
	
	@Override
	public void execute(Model model, SqlSession session) {
		ContactDAO dao = session.getMapper(ContactDAO.class);
		List<Contact> list = dao.selectListContact();
		model.addAttribute("list", list);
	}
	
}
