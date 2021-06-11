package ex02_resource;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("ex02_resource/app-context2.xml");
		
		SelectListCommand command = context.getBean("command", SelectListCommand.class);
		command.execute();
		
		context.close();
		
	}
	
}
