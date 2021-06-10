package quiz05;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		
		HoneyMoon moon1 = context.getBean("honeyMoon1",HoneyMoon.class);
		HoneyMoon moon2 = context.getBean("honeyMoon2",HoneyMoon.class);
		
		moon1.info();
		moon2.info();
		
		context.close();
		
	}
	
}
