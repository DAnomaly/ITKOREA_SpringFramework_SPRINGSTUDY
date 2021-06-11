package ex01_inject;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {

		/*
		SelectListCommand command = new SelectListCommand();
		command.execute();
		*/
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("ex01_inject/app-context1.xml");
		
		SelectListCommand command = context.getBean("command",SelectListCommand.class);
		
		command.execute();
		
		context.close();
	}
	
}
