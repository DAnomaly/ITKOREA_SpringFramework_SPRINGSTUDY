package quiz01;

public class Person {

	// field
	private String name;
	private Car car;
	
	// constructor
	public Person() {}
	
	// getter/setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}

	public void info() {
		System.out.println("이름: " + name);
		System.out.println("모델: " + car.getModel());
		System.out.println("가격: " + car.getPrice());
	}
	
}
