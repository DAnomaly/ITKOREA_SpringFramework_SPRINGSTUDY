package quiz03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("quiz03/quiz03.xml");
		
		Student student = context.getBean("student",Student.class);
		student.info();
		
		context.close();
	}
	
}
