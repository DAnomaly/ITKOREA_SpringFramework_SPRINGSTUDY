package ex06_java;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
	
	// field
	private String name;
	private List<Integer> scores;
	private Set<String> volunteers;
	private Map<String, String> home;
	
	// constructor
	
	// method
	public void info() {
		System.out.println("이름: " + name);
		System.out.println("점수: " + scores.toString());
		System.out.println("봉사활동: " + volunteers.toString());
		for (Map.Entry<String,String> entry : home.entrySet()) {
			System.out.println("집 " + entry.getKey() + ": " + entry.getValue()); 
		}
	}
	
	// getter
	public String getName() {
		return name;
	}
	public List<Integer> getScores() {
		return scores;
	}
	public Set<String> getVolunteers() {
		return volunteers;
	}
	public Map<String, String> getHome() {
		return home;
	}
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setScores(List<Integer> scores) {
		this.scores = scores;
	}
	public void setVolunteers(Set<String> volunteers) {
		this.volunteers = volunteers;
	}
	public void setHome(Map<String, String> home) {
		this.home = home;
	}
	
	
}
