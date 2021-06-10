package ex06_java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		
		Student student = context.getBean("student", Student.class);
		student.info();
		
		context.close();
		
	}
	
}
