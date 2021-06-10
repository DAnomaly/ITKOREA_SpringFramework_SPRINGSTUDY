package ex05_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
	@Configuration
	: 안녕. 나는 bean(객체)을 만들어 주는 Java 클래스야.
 */

@Configuration
public class AppContext {
	
	// Bean을 만드는 메소드를 하나씩 만든다.
	// 메소드 -> Bean 생성
	
	@Bean // 나는 Bean을 만드는 메소드이다.
	// 반환타입 : Song -> <bean class="Song">
	// 메소드명 : song() -> <bean id="song">
	public Song song() {
		Song s = new Song();
		s.setTitle("차 마시는 시간"); // <property name="title" value=""/>
		s.setGenre("인디뮤직"); // <property name="genre" value=""/>
		return s;
	}
	
	@Bean(name="singer") // <bean id="singer">
	public Singer xyz() { // 메소드명은 사용되지 않는다.
		return new Singer("묘야", song());
	}
	
}
