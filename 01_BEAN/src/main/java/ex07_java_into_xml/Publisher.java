package ex07_java_into_xml;

public class Publisher {
	
	// field
	private String name;
	private String location;
	
	// constructor
	public Publisher() {}
	public Publisher(String name, String location) {
		super();
		this.name = name;
		this.location = location;
	}
	
	// method
	// getter
	public String getName() {
		return name;
	}
	public String getLocation() {
		return location;
	}
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
