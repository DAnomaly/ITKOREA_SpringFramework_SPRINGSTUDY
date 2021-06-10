package ex04_xml;

import java.util.List;

public class Member {


	// field(property)
	private String name;
	private double height;
	private double weight;
	private BMICalculator bmiCalculator;
	private List<String> services;
	
	// constructor
	// default
	
	// method
	public void info() {
		System.out.println("회원명: " + name);
		System.out.println("키: " + height + "(cm)");
		System.out.println("몸무게: " + weight + "(kg)");
		bmiCalculator.info(height, weight);
		System.out.println("등록: " + services.toString());
	}

	// getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public BMICalculator getBmiCalculator() {
		return bmiCalculator;
	}
	public void setBmiCalculator(BMICalculator bmiCalculator) {
		this.bmiCalculator = bmiCalculator;
	}
	public List<String> getServices() {
		return services;
	}
	public void setServices(List<String> services) {
		this.services = services;
	}
	
}
