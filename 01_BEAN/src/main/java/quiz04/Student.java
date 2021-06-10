package quiz04;

public class Student {

	// field
	private String name;
	private Lecture lecture;

	// constructor
	public Student() {
	}
	public Student(String name, Lecture lecture) {
		super();
		this.name = name;
		this.lecture = lecture;
	}
	
	// method
	public void info() {
		System.out.println("이름: " + name);
		System.out.println("강좌명: " + lecture.getName());
		System.out.println("교수명: " + lecture.getProfessor());
	}
	// getter
	public String getName() {
		return name;
	}
	public Lecture getLecture() {
		return lecture;
	}
	// setter
	public void setName(String name) {
		this.name = name;
	}
	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}
	
	
}
