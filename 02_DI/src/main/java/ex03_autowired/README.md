# ex03_autowired
**@Autowired**는 주입하려고 하는 객체의 **타입**이 일치하는 객체를 자동으로 주입한다.  
**@Autowired**는 필드, 생성자, Setter에 붙일 수 있다.

## SelectListCommand.java
1. field를 이용한 방법
```
@Autowired
private Dao dao;
```
2. constructor를 이용한 방법
```
@Autowired
public SelectListCommand(Dao dao) {
  this.dao = dao;
}
```
3. setter를 이용한 방법
```
@Autowired
public void setDao(Dao dao) {
  this.dao = dao;
}
```

## app-context3.xml
**@Autowired**를 사용하는 경우 **XmlBean**에 아래를 추가해 주자
1. **context** 추가
```
xmlns:context="http://www.springframework.org/schema/context"
```
2. **```<context:annotation-config/>```** 추가
```
<context:annotation-config/>
<context:component-scan base-package="ex02_resource"/>
```

## 동일 타입이 있을 경우
**@Qualifier**를 이용하여 Bean을 지정할 수 있다
### SelectListCommand.java
```
@Autowired
@Qualifier("usedDao")
public void setDao(Dao dao) {
  this.dao = dao;
}
```
### app-context3.xml
```
<bean id="dao" class="ex03_autowired.Dao">
  <qualifier value="usedDao"/>
</bean>
```