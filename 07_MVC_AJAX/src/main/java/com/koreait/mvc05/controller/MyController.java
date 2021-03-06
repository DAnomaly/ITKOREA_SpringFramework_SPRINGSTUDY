package com.koreait.mvc05.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.mvc05.dto.Person;

@Controller
public class MyController {

	@RequestMapping("/")
	public String contextPath() {
		return "index";
	}
	
	// 텍스트로 전송
	@RequestMapping(
			value="v01",
			method=RequestMethod.GET,
			produces="text/plain; charset=UTF-8")
	@ResponseBody // ajax 처리를 위한 필수 애너테이션
	public String v01(
			@RequestParam(value="name", required=false, defaultValue="default") String name, 
			@RequestParam(value="age", required=false, defaultValue="0") int age) {
		return name + ", " + age;
	}
	
	// Map클래스로 전송
	@RequestMapping(
			value="v02",
			method=RequestMethod.GET,
			produces="application/json; charset=UTF-8")
	@ResponseBody
	public Map<String, Object> v02(
			@RequestParam(value="name", required=false, defaultValue="default") String name, 
			@RequestParam(value="age", required=false, defaultValue="0") int age) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("age", age);
		return map;
	}
	
	// Person클래스로 전송
	/*
	@RequestMapping(
			value="v03",
			method=RequestMethod.GET,
			produces="application/json; charset=UTF-8")
	@ResponseBody
	public Person v03(
			@RequestParam(value="name", required=false, defaultValue="default") String name, 
			@RequestParam(value="age", required=false, defaultValue="0") int age) {
		Person p = new Person();
		p.setName(name);
		p.setAge(age);
		
		System.out.println(p);
		
		return p;
	}
	*/
	@RequestMapping(
			value="v03",
			method=RequestMethod.POST,
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Person v03(
			@RequestBody Person person) { 
		
		return person;
	}
}
