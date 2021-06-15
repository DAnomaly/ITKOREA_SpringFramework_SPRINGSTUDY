package com.koreait.mvc03.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koreait.mvc03.dto.Person;

@Controller
public class MyController6 {

	/*
		전달 받은 파라미터 처리
		
		1. HttpServletRequest request
		2. @RequestParam
		3. DTO를 사용
		4. @ModelAttribute
	 */
	
	// 1. request 이용하기
	@RequestMapping("f5/v01")
	public String a(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		
		// 기존 방법
		/*
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		*/
		
		// Map을 이용하여 model에 데이터 넣기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("age", age);
		
		model.addAllAttributes(map);
		
		return "folder05/view01";
	}
	
	// 2-1. @RequestParam
	@RequestMapping("f5/v02")
	public String b(Model model,
			@RequestParam("name") String name,
			@RequestParam("age") int age) {
	// public String b(Model model, String name, int age) {
	// 파라미터 명이 같으면 생략이 가능합니다.(생략가능 : @RequestParam("파라미터명") String 파라미터명 ) 
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		
		return "folder05/view02";
	}
	
	/*
	 	만약 파라미터 값이 없으면..
	 */
	// 2-2. @RequestParam
		@RequestMapping("f5/v03")
		public String c(Model model,
				// @RequestParam의 Null값 처리
				// required=false : 전달값이 없어도 된다.
				// defaultValue="0" : 전달값이 없을경우 해당 값을 사용한다.
				@RequestParam(value="name", required=false) String name,
				@RequestParam(value="age", required=false, defaultValue="0") int age) {
			model.addAttribute("name",name);
			model.addAttribute("age",age);
			
			return "folder05/view03";
		}
	
	// 3. DTO를 사용
	@RequestMapping("f5/v04")
	public String d(Model model, Person person) {
			// 오류 범위 : age= 과 같이 값을 여백으로 넘기면 parsing 오류가 발생한다.
		model.addAttribute("person", person);
		
		return "folder05/view04";
	}

	// 4-1. @ModelAttribute
	@RequestMapping("f5/v05")
	public String e(@ModelAttribute(value="name") String name,
			@ModelAttribute(value="age") int age) {
		 	// 파라미터 name을 String name에 저장한 뒤 model에 저장한다.
		return "folder05/view05";
	}
	
	// 4-2. @ModelAttribute
	@RequestMapping("f5/v06")
	public String f(@ModelAttribute("person") Person person) {
		return "folder05/view06";
	}
}
