package ex05_java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		// @Configuration 애너테이션을 처리할 클래스는 AnnotationConfigApplicationContext 
		// AbstractApplicationContext가 부모클래스
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);
		
		Singer singer = context.getBean("singer",Singer.class);
		
		singer.info();
		
		context.close();
		
	}
	
}
