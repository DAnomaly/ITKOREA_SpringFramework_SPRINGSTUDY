package com.koreait.mvc03.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.koreait.mvc03.dto.Person;

@Configuration
public class BeanConfiguration {

	@Bean
	public Person man() {
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("골프");
		hobbies.add("당구");
		return new Person("남자", 48, hobbies);
	}
	
	@Bean
	public Person woman() {
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("요리");
		return new Person("여자", 48, hobbies);
	}
}
