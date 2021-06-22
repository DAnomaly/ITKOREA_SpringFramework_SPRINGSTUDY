package com.koreait.contact03.command;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.contact03.dao.ContactDAO;
import com.koreait.contact03.dto.Contact;

public class SelectOneContactCommand implements ContactCommand {

	@Override
	public void execute(Model model, SqlSession session) {
		long no = (Long)model.asMap().get("no");
		ContactDAO dao = session.getMapper(ContactDAO.class);
		Contact contact = dao.selectOneContact(no);
		model.addAttribute("contact",contact);
	}

}
