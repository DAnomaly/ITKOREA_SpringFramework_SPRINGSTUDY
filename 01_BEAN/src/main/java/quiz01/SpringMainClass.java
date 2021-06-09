package quiz01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		String resources = "classpath:quiz01/quiz01.xml";
		AbstractApplicationContext context = new GenericXmlApplicationContext(resources);
		
		Person person = (Person)context.getBean("person");
		
		person.info();
		
		context.close();
		
	}
	
}
