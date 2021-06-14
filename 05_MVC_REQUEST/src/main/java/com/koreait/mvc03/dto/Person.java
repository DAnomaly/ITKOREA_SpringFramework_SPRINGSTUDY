package com.koreait.mvc03.dto;

import java.util.List;

public class Person {

	// field
	private String name;
	private int age;
	List<String> hobbies;
	
	// constructor
	public Person() {}
	public Person(String name, int age, List<String> hobbies) {
		this.name = name;
		this.age = age;
		this.hobbies = hobbies;
	}
	
	// getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}
	
}
