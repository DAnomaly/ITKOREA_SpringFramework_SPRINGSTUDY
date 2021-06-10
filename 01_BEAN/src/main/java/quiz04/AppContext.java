package quiz04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	@Bean
	public Lecture lecture2() {
		Lecture lecture = new Lecture();
		lecture.setName("컴퓨터공학");
		lecture.setProfessor("텀블러");
		return lecture;
	}
	
	@Bean
	public Student student2() {
		return new Student("컴퓨터",lecture2());
	}
	
}
