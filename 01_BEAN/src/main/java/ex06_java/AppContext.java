package ex06_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	@Bean
	public Student student() {
		Student student = new Student();
		student.setName("bread");
		List<Integer> scores = new ArrayList<Integer>();
		scores.add(90);
		scores.add(80);
		scores.add(85);
		student.setScores(scores);
		Set<String> volunteers = new HashSet<String>();
		volunteers.add("고아원");
		volunteers.add("양로원");
		student.setVolunteers(volunteers);
		Map<String, String> home = new HashMap<String, String>();
		home.put("전화번호", "02-123-4567");
		home.put("주소", "서울");
		student.setHome(home);
		
		return student;
	}
	
}
