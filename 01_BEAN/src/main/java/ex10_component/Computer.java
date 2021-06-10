package ex10_component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("com")
@Scope("prototype")
public class Computer {
	public void info() {
		System.out.println("나는 컴퓨터다.");
	}
}
