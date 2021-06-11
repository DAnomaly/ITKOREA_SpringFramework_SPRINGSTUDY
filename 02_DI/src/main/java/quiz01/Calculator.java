package quiz01;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	// method 
	public double add (double a, double b) {
		return a + b;
	}
	public double subtract (double a, double b) {
		return a - b;
	}
	public double multiply (double a, double b) {
		return a * b;
	}
	public double divide (double a, double b) {
		return a / b;
	}
	
}
