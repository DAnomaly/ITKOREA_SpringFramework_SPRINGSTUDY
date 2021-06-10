package quiz04;

public class Lecture {

	// field
	private String name;
	private String professor;
	
	// constructor
	public Lecture() {}
	public Lecture(String name, String professor) {
		super();
		this.name = name;
		this.professor = professor;
	}
	
	// getter
	public String getName() {
		return name;
	}
	public String getProfessor() {
		return professor;
	}
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	
}
