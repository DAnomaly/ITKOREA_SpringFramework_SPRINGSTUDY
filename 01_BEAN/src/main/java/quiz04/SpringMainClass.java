package quiz04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("quiz04/quiz04.xml");
		
		Student student1 = context.getBean("student1",Student.class);
		Student student2 = context.getBean("student2",Student.class);
		
		student1.info();
		student2.info();
		
		context.close();
	}
	
}
