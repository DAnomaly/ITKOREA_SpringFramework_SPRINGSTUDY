package quiz05;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("quiz05/quiz05.xml")
@Configuration
public class AppContext {
	
	@Bean(name="husband2")
	public Person person1() {
		Person p = new Person();
		p.setName("David");
		p.setGender("남");
		return p;
	}
	
	@Bean(name="wife2")
	public Person person2() {
		Person p = new Person();
		p.setName("shew");
		p.setGender("여");
		return p;
	}
	
	@Bean(name="honeyMoon2")
	public HoneyMoon honeymoon() {
		HoneyMoon h = new HoneyMoon();
		h.setCity("EnterPrize");
		h.setHusband(person1());
		h.setWife(person2());
		return h;
	}
}
