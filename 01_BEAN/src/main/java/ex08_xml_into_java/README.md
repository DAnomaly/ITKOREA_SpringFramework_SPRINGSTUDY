# ex08_xml_into_java
  * XmlBean을 JavaBean에 추가하기

## AppContext.java
  * 자바 클래스에 @ImportResource 애너테이션을 추가한다.
```
@ImportResource("XmlBean의주소")
@Configuration
public class 클래스명 { }
```