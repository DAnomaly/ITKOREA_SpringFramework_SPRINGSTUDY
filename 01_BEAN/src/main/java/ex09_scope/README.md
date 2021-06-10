# ex09_scope
* scope 속성 : prototype, request, session, application, websocket
* 기본값 : single-ton
* prototype : Bean을 요청할 때마다 생성해서 제공한다.

## AppContext.java
```
@Bean
@Scope("prototype")
public Person person2() {
  return new Person("데이빗",30);
}
```

## app-context9.xml
```
<bean id="person1" class="ex09_scope.Person" scope="prototype">
  <property name="name" value="에밀리"/>
  <property name="age" value="25"/>
</bean>
```