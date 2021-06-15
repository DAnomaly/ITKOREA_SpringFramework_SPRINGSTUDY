package com.koreait.mvc4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.mvc4.dto.Person;

@Controller
public class MyController {

	@RequestMapping("v01")
	public String v01(
			@RequestParam("name") String name,
			@RequestParam("age") int age) {
		
		System.out.println(name + ",  " + age);
		
		return "result";
	}
	
	@RequestMapping("v02")
	public String v02(Person person) {
		
		System.out.println(person.toString());
		
		return "redirect:v03";
	}
	
	@RequestMapping("v03")
	public String v03() {
		
		return "result";
	}
	
	@RequestMapping("v04")
	public String v04(Person person) {
		
		return "redirect:v05?name=" + person.getName() + "&age=" + person.getAge();
	}
	
	// redirect로 이동할 때 데이터 전달하기
	// 1. 새로운 파라미터를 추가해서 보낸다.
	// 2. RedirectAttributes 인터페이스를 이용한다.
	
	@RequestMapping("v05")
	public String v05(Person person){
		System.out.println(person);
		return "result";
	}
	
	@RequestMapping("v06")
	public String v06(Person person,
			RedirectAttributes rttr){
		System.out.println(person);
		rttr.addFlashAttribute("name",person.getName());
		rttr.addFlashAttribute("age",person.getAge());
		return"redirect:v07";
	}
	
	@RequestMapping("v07")
	public String v07(String name, int age){
		return"result";
	}
	
}
