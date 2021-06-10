# ex05_java

## AppContext.java
* @Configeration : bean을 만들어 주는 자바 클래스 선언
```
@Configuration
public class 클래스명 { }
```
* @Bean : Bean객체를 만드는 메소드 선언
```
@Bean
public 반환타입 메소드명() {
  return 반환할메소드;
}

@Bean(name="메소드명")
public 반환타입 임의의명() {
  return 반환할메소드;
}
```
----------
## SpringMainClass.java
* AnnotationConfigApplicationContext : @Configeration 클래스 안의 @Bean 객체를 생성해 주는 클래스
```
예시)
AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppContext.class);

Singer singer = context.getBean("singer",Singer.class);

singer.info();

context.close();
```
