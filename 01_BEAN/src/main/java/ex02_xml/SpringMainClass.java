package ex02_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		String resourceLocations = "classpath:ex02_xml/app-context2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		Car car = (Car)ctx.getBean("car");
		car.info();
		
		ctx.close();
	}
}
