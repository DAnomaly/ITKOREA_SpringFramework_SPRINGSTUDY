# ex10_component
@Component
1. Bean으로 만들 클래스를 직접 Bean으로 생성해 준다.
2. XmlBean이나 JavaBean을 별도로 생성하지 않아도 생성된다.
3. ComponentScan을 통해서 Component를 찾는 방식으로 동작한다.
4. bean의 아이디는 자동으로 부여된다. ex) Class="Person" -> id="person"

## Person.java
* component 생성 방법
```
@Component
public class Person {}
```
## app-context10.xml
* componentScan을 통해 Component를 찾는 방법
```
1단계 : Namespaces탭에서 context를 추가한다.
2단계 : <context:component-scan> 태그를 작성한다.

<context:component-scan base-package="ex10_component"/>
```

## AppContext.java
* @ComponentScan 을 통해 Component를 찾는 방법
```
@Configuration
@ComponentScan(basePackages="ex10_component")
// @ComponentScan(basePackages= {"ex10_component"})
public class AppContext {}
```