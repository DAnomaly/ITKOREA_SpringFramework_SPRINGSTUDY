package ex04_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("ex04_xml/app-context4.xml");

		Member member = context.getBean("member",Member.class);
		
		member.info();
		
		context.close();
	}
	
}
