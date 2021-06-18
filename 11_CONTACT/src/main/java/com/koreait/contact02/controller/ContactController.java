package com.koreait.contact02.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.contact02.command.ContactCommand;
import com.koreait.contact02.command.DeleteContactCommand;
import com.koreait.contact02.command.InsertContactCommand;
import com.koreait.contact02.command.SelectListContactCommand;
import com.koreait.contact02.command.SelectOneContactCommand;
import com.koreait.contact02.command.UpdateContactCommand;
import com.koreait.contact02.config.BeanConfiguration;
import com.koreait.contact02.dto.Contact;

@Controller
@RequestMapping("contact")
public class ContactController {
	
	// field
	AbstractApplicationContext ctx;
	public ContactController() {
		ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
	}
	
	@RequestMapping(value= {"/"})
	public String index() {
		return "redirect:list.do";
	}
	
	@RequestMapping("list.do")
	public String list(Model model) {
		ContactCommand command = ctx.getBean("selectListContactCommand", SelectListContactCommand.class); 
		command.execute(model);
		return "contact/list";
	}
	
	@RequestMapping("view.do")
	public String view(Model model,
			long no) {
		model.addAttribute("no",no);
		ContactCommand command = ctx.getBean("selectOneContactCommand",SelectOneContactCommand.class);
		boolean iswork = command.execute(model);
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
		ContactCommand command = ctx.getBean("insertContactCommand",InsertContactCommand.class);
		boolean iswork = command.execute(model);
		if(iswork)
			return "redirect:success";
		else
			return "redirect:error";
	}
	
	@GetMapping("delete.do")
	public String delete(Model model,
			long no) {
		model.addAttribute("no",no);
		ContactCommand command = ctx.getBean("deleteContactCommand",DeleteContactCommand.class);
		boolean iswork = command.execute(model);
		if(iswork)
			return "redirect:success";
		else
			return "redirect:error";
	}
	
	@PostMapping("update.do")
	public String update(Model model,
			@ModelAttribute Contact contact) {
		ContactCommand command = ctx.getBean("updateContactCommand",UpdateContactCommand.class);
		boolean iswork = command.execute(model);
		if(iswork)
			return "redirect:updateSuccess?no=" + contact.getNo();
		else
			return "redirect:error";
	}
}
