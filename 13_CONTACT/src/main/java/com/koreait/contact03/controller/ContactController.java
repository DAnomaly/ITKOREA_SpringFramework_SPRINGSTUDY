package com.koreait.contact03.controller;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.contact03.command.DeleteContactCommand;
import com.koreait.contact03.command.InsertContactCommand;
import com.koreait.contact03.command.SelectListContactCommand;
import com.koreait.contact03.command.SelectOneContactCommand;
import com.koreait.contact03.command.UpdateContactCommand;
import com.koreait.contact03.dto.Contact;

@Controller
@RequestMapping("contact")
public class ContactController {

	private SqlSession session;
	
	private SelectListContactCommand selectListContactCommand;
	private SelectOneContactCommand selectOneContactCommand;
	private InsertContactCommand insertContactCommand;
	private UpdateContactCommand updateContactCommand;
	private DeleteContactCommand deleteContactCommand;

	@Autowired
	public ContactController(
			SqlSession session,
			SelectListContactCommand selectListContactCommand,
			SelectOneContactCommand selectOneContactCommand,
			InsertContactCommand insertContactCommand,
			UpdateContactCommand updateContactCommand,
			DeleteContactCommand deleteContactCommand) {
		this.session = session;
		this.selectListContactCommand = selectListContactCommand;
		this.selectOneContactCommand = selectOneContactCommand;
		this.insertContactCommand = insertContactCommand;
		this.updateContactCommand = updateContactCommand;
		this.deleteContactCommand = deleteContactCommand;
	}
	
	@RequestMapping("list.do") 
	public String list(Model model) {
		selectListContactCommand.execute(model, session);
		return "contact/list";
	}
	
	@RequestMapping("view.do")
	public String view(
			Model model,
			long no) {
		model.addAttribute("no",no);
		selectOneContactCommand.execute(model, session);
		return "contact/view";
	}
	
	@RequestMapping("insertView.do")
	public String insertView() {
		return "contact/insert";
	}
	
	@RequestMapping("insert.do")
	public void insert(
			Model model,
			Contact contact,
			HttpServletResponse response) {
		model.addAttribute("contact",contact);
		model.addAttribute("response",response);
		insertContactCommand.execute(model, session);
	}
	
	@RequestMapping("update.do")
	public void update(
			Model model,
			Contact Contact,
			HttpServletResponse response) {
		model.addAttribute("Contact",Contact);
		model.addAttribute("response",response);
		updateContactCommand.execute(model, session);
	}
	
	@RequestMapping("delete.do")
	public void delete(
			Model model,
			long no,
			HttpServletResponse response) {
		model.addAttribute("no",no);
		model.addAttribute("response",response);
		deleteContactCommand.execute(model, session);
	}
	
}
