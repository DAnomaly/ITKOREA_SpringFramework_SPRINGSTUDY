package ex10_component;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("ex10_component/app-context10.xml");
		
		Person p = ctx.getBean("person",Person.class);
		p.info();
		
		Book b = ctx.getBean("bk",Book.class);
		b.info();
		
		ctx.close();

		AbstractApplicationContext ctx2 = new AnnotationConfigApplicationContext(AppContext.class);
		
		Person p2 = ctx2.getBean("person",Person.class);
		p2.info();
		
		Book b2 = ctx2.getBean("bk",Book.class);
		b2.info();
		
		ctx2.close();

	}
}
