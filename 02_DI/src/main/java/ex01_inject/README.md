# ex01_inject
## @Inject
1. 객체의 타입(``<bean class="">``)이 일치하는 객체를 자동으로 주입한다.
2. 필드, 생성자, setter를 대상으로 한다.

```
<!-- @Inject를 위해서 추가한 디펜던시 -->
<dependency>
  <groupId>javax.inject</groupId>
  <artifactId>javax.inject</artifactId>
  <version>1</version>
</dependency>
```
## SelectListCommand.java
1. **필드**을 이용해 주입하기
```
@Inject
private Dao dao;
```
2. **생성자**를 이용해서 주입하기
```
@Inject 
public SelectListCommand(Dao dao) {
  this.dao = dao;
}
```
3. **setter**를 이용해서 주입하기
```
@Inject	
public void setDao(Dao dao) {
  this.dao = dao;
}
```

### 동일한 class의 Bean이 **2개 이상** 존재할 경우
**@Named**에 **id**를 지정하여 사용할 수 있다.
```
@Inject
@Named("dao1")
public SelectListCommand(Dao dao) {
  this.dao = dao;
}
```

## app-context1.xml
**@Inject**를 사용하는 경우 **XmlBean**에 아래를 추가해 주자
1. **context** 추가
```
xmlns:context="http://www.springframework.org/schema/context"
```
2. **```<context:annotation-config/>```** 추가
```
<context:annotation-config/>
<context:component-scan base-package="ex01_inject"/>
```