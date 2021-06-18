package com.koreait.contact02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value= {"/","contact"})
	public String index() {
		return "redirect:contact/list.do";
	}
	
}
