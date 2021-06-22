package com.koreait.contact03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value={"/","index"})
	public String index() {
		return "redirect:contact/list.do";
	}
	
}
