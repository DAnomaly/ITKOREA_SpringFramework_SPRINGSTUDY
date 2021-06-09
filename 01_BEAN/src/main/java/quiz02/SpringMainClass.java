package quiz02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		String resource = "quiz02/quiz02.xml";
		
		AbstractApplicationContext content = new GenericXmlApplicationContext(resource);
		
		MultiplicationTable table = content.getBean("multiplicationTable", MultiplicationTable.class);
		table.info();
		
		content.close();
		
	}
}
