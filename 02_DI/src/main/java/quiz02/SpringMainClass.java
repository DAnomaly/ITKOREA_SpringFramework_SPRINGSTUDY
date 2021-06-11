package quiz02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
	
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		
		TV tv = context.getBean("tv",TV.class);
		tv.chUp();
		tv.chUp();
		tv.chUp();
		tv.volDown(7);
		tv.info();
		
		context.close();
		
	}
	
}
