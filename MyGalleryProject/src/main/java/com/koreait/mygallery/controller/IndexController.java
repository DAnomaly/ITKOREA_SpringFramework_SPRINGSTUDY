package com.koreait.mygallery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value= {"/","index.do"})
	public String index() {
		return "redirect:gallery/list.do";
	}
	
}
