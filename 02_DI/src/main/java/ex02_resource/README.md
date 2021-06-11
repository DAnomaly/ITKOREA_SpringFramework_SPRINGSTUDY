# ex02_resource

## @Resource
**@Resource**는 주입하려고 하는 객체의 **이름(id)** 이 일치하는 객체를 자동으로 주입한다.  
**@Resource**는 Java 제공 애노테이션이며 필드, Setter에 붙일 수 있다. 생성자에는 붙일 수 없다.  
**@Autowired**와 마찬가지로 반드시 기본 생성자가 정의되어 있어야 한다.
```
<!-- @Resource를 위해서 추가한 디펜던시 -->
<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.2</version>
</dependency>
```

## SelectListCommand.java
1. field를 이용한 주입
```
@Resource
private Dao dao;
```
2. setter를 이용한 주입
```
@Resource
public void setDao(Dao dao) {
  this.dao = dao;
}
```
3. constructor는 불가능

## app-context2.xml
**@Resource**를 사용하는 경우 **XmlBean**에 아래를 추가해 주자
1. **context** 추가
```
xmlns:context="http://www.springframework.org/schema/context"
```
2. **```<context:annotation-config/>```** 추가
```
<context:annotation-config/>
<context:component-scan base-package="ex02_resource"/>
```