package com.koreait.mvc03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("member") // member로 시작하는 모든 매핑을 처리하는 컨트롤러이다.
public class MyController2 {

	@RequestMapping("view03")
	public String a() {
		return "folder01/view03";
	}
	
}
