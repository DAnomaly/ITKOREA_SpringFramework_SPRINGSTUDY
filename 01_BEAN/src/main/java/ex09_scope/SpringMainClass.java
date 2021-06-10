package ex09_scope;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("ex09_scope/app-context9.xml");
		
		Person p1 = ctx.getBean("person1",Person.class); 
		Person p2 = ctx.getBean("person1",Person.class); 
				
		System.out.println(p1.equals(p2));
		
		ctx.close();
		
		AbstractApplicationContext ctx2 = new AnnotationConfigApplicationContext(AppContext.class);
		
		Person p3 = ctx2.getBean("person2",Person.class);
		Person p4 = ctx2.getBean("person2",Person.class);
		
		System.out.println(p3.equals(p4));
		
		ctx2.close();
		
	}
}
