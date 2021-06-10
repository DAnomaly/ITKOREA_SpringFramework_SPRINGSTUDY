package ex07_java_into_xml;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {

	@Bean(name="publisher2")
	public Publisher pub() {
		return new Publisher("스프링출판사","경기도 성남시");
	}
	
	@Bean(name="book2")
	public Book bk() {
		return new Book("나는스프링박사", 30000, pub());
	}
	
}
