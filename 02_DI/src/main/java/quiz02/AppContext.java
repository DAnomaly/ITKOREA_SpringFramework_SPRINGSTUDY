package quiz02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppContext {
	
	@Bean
	public Speaker speaker() {
		Speaker speaker = new Speaker();
		speaker.setVolume(20);
		return speaker;
	}
	
	@Bean
	public TV tv() {
		TV tv = new TV();
		tv.setCh(7);
		return tv;
	}
}
