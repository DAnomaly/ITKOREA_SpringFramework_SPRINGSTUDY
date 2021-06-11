package quiz01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EngineerCalculator {

	// field
	private Calculator calculator;
	
	// setter
	@Autowired
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	// method 
	public void add (double a, double b) {
		System.out.println(a + "+" + b + "=" + calculator.add(a, b));
	}
	public void subtract (double a, double b) {
		System.out.println(a + "-" + b + "=" + calculator.subtract(a, b));
	}
	public void multiply (double a, double b) {
		System.out.println(a + "x" + b + "=" + calculator.multiply(a, b));
	}
	public void divide (double a, double b) {
		System.out.println(a + "/" + b + "=" + calculator.divide(a, b));
	}
	
	
}
