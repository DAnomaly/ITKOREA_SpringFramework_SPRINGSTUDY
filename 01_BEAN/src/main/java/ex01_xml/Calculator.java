package ex01_xml;

public class Calculator {
	
	// field (property)
	
	
	// constructor
	public Calculator() {
		super();
	}
	
	// method
	public void add(int a, int b) {
		System.out.println(a + "+" + b + "=" + (a + b));
	}
	
	public void subtract(int a, int b) {
		System.out.println(a + "-" + b + "=" + (a - b));
	}
	
	public void multiply(int a, int b) {
		System.out.println(a + "x" + b + "=" + (a * b));
	}
	
	public void divide(int a, int b) {
		System.out.println(a + "/" + b + "=" + ((double)a / b));
	}
	
	
}
