package ex01_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		// spring bean configuration file에 정의된 <bean>을 생성하는 클래스
		// GenericXmlApplicationContext 
		
		// AbstractApplicationContext는 GenericXmlApplicationContext의 슈퍼 클래스
		
		String resourceLocations = "classpath:ex01_xml/app-context1.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocations);
		
		// 이미 스프링은 app-context1.xml에 정의된 Bean을 모두 생성해서 가지고 있다.
		// 개발자는 필요한 Bean을 getBean() 메소드를 이용해서 가져다 사용한다.
		
		// 기존 : 개발자가 직접 Bean을 생성한다.
		// 스프링 : 스프링이 미리 Bean을 생성해 둔다.
		// IoC : Inversion of Control, 제어의 역전
		EngineerCalculator engineerCalculator1 = (EngineerCalculator)ctx.getBean("engineerCalculator1");
		EngineerCalculator engineerCalculator2 = (EngineerCalculator)ctx.getBean("engineerCalculator2");
		EngineerCalculator engineerCalculator3 = (EngineerCalculator)ctx.getBean("engineerCalculator3");
		EngineerCalculator engineerCalculator4 = (EngineerCalculator)ctx.getBean("engineerCalculator4");
		
		engineerCalculator1.add();
		engineerCalculator1.subtract();
		engineerCalculator1.multiply();
		engineerCalculator1.divide();
		System.out.println();
		engineerCalculator2.add();
		engineerCalculator2.subtract();
		engineerCalculator2.multiply();
		engineerCalculator2.divide();
		System.out.println();
		engineerCalculator3.add();
		engineerCalculator3.subtract();
		engineerCalculator3.multiply();
		engineerCalculator3.divide();
		System.out.println();
		engineerCalculator4.add();
		engineerCalculator4.subtract();
		engineerCalculator4.multiply();
		engineerCalculator4.divide();
		System.out.println();
		
		ctx.close();
	}
}
