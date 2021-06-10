package ex10_component;

import org.springframework.stereotype.Component;

/*
 	@Component
 	1. Bean으로 만들 클래스를 직접 Bean으로 생성해 준다.
 	2. XmlBean이나 JavaBean을 별도로 생성하지 않아도 생성된다.
 */

@Component
public class Person { // id="person"

	public void info() {
		System.out.println("나는 사람이다.");
	}
	
}
