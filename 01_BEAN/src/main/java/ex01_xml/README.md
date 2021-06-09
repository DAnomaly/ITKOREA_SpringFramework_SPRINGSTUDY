# ex01_xml
 참고: ../resources/ex01_xml/app-context1.xml  
 * JavaMainClass.java : 자바의 기본 동작
 * SpringMainClass.java : 스프링의 Bean을 통한 동작
 * app-context1.xml : JavaBean 생성

## bean 객체의 기본 생성 방법
```
1. 디폴트 생성자
<bean id="객체명" class="클래스명"/> 
<bean id="객체명" class="클래스명"></bean>
  
2-1. 디폴트 생성자 + setter
<bean id="객체명" class="클래스명">
  <property name="필드명">
    <value>값</value>
  </property>
  <property name="필드명">
    <ref bean="객체명"/>
  </property>
</bean>

2-2. 디폴트 생성자 + setter
<bean id="객체명" class="클래스명">
  <property name="필드명" value="값"/>
  <property name="필드명" ref="객체명"/>
</bean>

3-1. 필드 생성자
<bean id="객체명" class="클래스명">
  <constructor-arg>
    <value>1번째인수</value>
  </constructor-arg>
  <constructor-arg>
    <value>2번째인수</value>
  </constructor-arg>
  <constructor-arg>
    <ref bean="객체명"/>
  </constructor-arg>
</bean>

3-2. 필드 생성자
<bean id="engineerCalculator4" class="ex01_xml.EngineerCalculator">
  <constructor-arg name="필드명" value="값"/>
  <constructor-arg name="필드명" value="값"/>
  <constructor-arg name="필드명" ref="객체명"/>
</bean>
```