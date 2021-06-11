package quiz01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		EngineerCalculator cal = context.getBean("engineerCalculator",EngineerCalculator.class);
		cal.add(5, 8);
		cal.subtract(8.5, 2.5);
		cal.multiply(6, 3.2);
		cal.divide(6.3, 2.1);
		
		context.close();
	}
	
}
