package ex03_autowired;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("ex03_autowired/app-context3.xml");

		SelectListCommand command = context.getBean("command",SelectListCommand.class);
		command.execute();
		
		context.close();
	}
	
}
