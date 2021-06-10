package ex08_xml_into_java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		
		Soldier s1 = context.getBean("soldier1", Soldier.class);
		Soldier s2 = context.getBean("soldier2", Soldier.class);
		
		s1.info();
		s2.info();
		
		context.close();
		
	}
	
}
