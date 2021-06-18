package com.koreait.contact01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.contact01.command.DeleteContactCommand;
import com.koreait.contact01.command.InsertContactCommand;
import com.koreait.contact01.command.SelectListContactCommand;
import com.koreait.contact01.command.SelectOneContactCommand;
import com.koreait.contact01.command.UpdateContactCommand;
import com.koreait.contact01.dto.Contact;

@Controller
@RequestMapping("contact")
public class ContactController {
	
	// field
	DeleteContactCommand deleteContactCommand;
	InsertContactCommand insertContactCommand;
	SelectListContactCommand selectListContactCommand;
	SelectOneContactCommand selectOneContactCommand;
	UpdateContactCommand updateContactCommand;

	@Autowired
	public void setCommand(
			DeleteContactCommand deleteContactCommand,
			InsertContactCommand insertContactCommand,
			SelectListContactCommand selectListContactCommand,
			SelectOneContactCommand selectOneContactCommand,
			UpdateContactCommand updateContactCommand) {
		this.deleteContactCommand = deleteContactCommand;
		this.insertContactCommand = insertContactCommand;
		this.selectListContactCommand = selectListContactCommand;
		this.selectOneContactCommand = selectOneContactCommand;
		this.updateContactCommand = updateContactCommand;
	}
	
	@RequestMapping("list.do")
	public String list(Model model) {
		selectListContactCommand.execute(model);
		return "contact/list";
	}
	
	@RequestMapping("view.do")
	public String view(Model model,
			long no) {
		model.addAttribute("no",no);
		boolean iswork = selectOneContactCommand.execute(model);
		if(iswork)
			return "contact/view";
		else
			return "redirect:error";
	}
	
	@RequestMapping("insertView.do")
	public String insertView(Model model) {
		return "contact/insert";
	}
	
	@PostMapping("insert.do")
	public String insert(Model model,
			@ModelAttribute Contact contact) {
		boolean iswork = insertContactCommand.execute(model);
		if(iswork)
			return "redirect:success";
		else
			return "redirect:error";
	}
	
	@GetMapping("delete.do")
	public String delete(Model model,
			long no) {
		model.addAttribute("no",no);
		boolean iswork = deleteContactCommand.execute(model);
		if(iswork)
			return "redirect:success";
		else
			return "redirect:error";
	}
	
	@PostMapping("update.do")
	public String update(Model model,
			@ModelAttribute Contact contact) {
		boolean iswork = updateContactCommand.execute(model);
		if(iswork)
			return "redirect:updateSuccess?no=" + contact.getNo();
		else
			return "redirect:error";
	}
}
