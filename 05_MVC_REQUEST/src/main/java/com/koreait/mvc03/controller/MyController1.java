package com.koreait.mvc03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController1 {
	
	// 모든 요청(URLMapping) 처리는 메소드 단위로 한다.
	
	// @RequestMapping(value="/", method=RequestMethod.GET)
	// 1. GET 방식의 method는 생략할 수 있다.
	//    @RequestMapping(value="/")
	// 2. value 속성만 작성하는 경우에는 value 속성 명시를 생략할 수 있다.
	//	  @RequestMapping("/")
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String a() {
		// 아래 return "index"는 servlet-context.xml에 의해서 다음과 같이 처리된다.
		// return "/WEB-INF/views/index.jsp"
		return "index"; // 이동 방식은 forward이다.
	}
	
	@RequestMapping("view01")
	// @RequestMapping("/view01") // 슬래시(/)로 시작해도 상관 없다.
	public String b() {
		return "folder01/view01";
		// return "/folder01/view01"; // 슬래시(/)로 시작해도 상관 없다.
	}
	
	// 실제 디렉터리 구조와 매핑값을 다르게 가져가서
	// 외부에서 주소를 통해 내부 구조를 예상하지 못하도록 처리한다.
	@RequestMapping("a/b/c/d/e/v02")
	public String c() {
		return "folder01/view02";
	}
	
	// 앞으로는 매핑 값을 작성할 때 슬래시(/)를 넣지 않겠다.
	
}
