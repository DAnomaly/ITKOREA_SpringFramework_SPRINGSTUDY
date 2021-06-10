package quiz05;

public class HoneyMoon {

	private String city;
	private Person husband;
	private Person wife;
	
	public void info() {
		System.out.println("city: " + city);
		System.out.println("husband: " + husband.getName());
		System.out.println("wife: " + wife.getName());
	}
	
	public String getCity() {
		return city;
	}
	public Person getHusband() {
		return husband;
	}
	public Person getWife() {
		return wife;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setHusband(Person husband) {
		this.husband = husband;
	}
	public void setWife(Person wife) {
		this.wife = wife;
	}
	
	
}
