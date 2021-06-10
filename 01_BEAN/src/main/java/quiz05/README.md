# quiz05

## 구현

### Person
```
private String name;
private String gender;
```

### HoneyMoon
```
private String city;
private Person husband;
private Person wife;
```

### CONTEXT
quiz05.xml 에서 각 Bean을 1개씩  
AppContext.java 에서 각 Bean을 1개씩  
AppContext.java 에서 quiz05.xml 불러오기  
GenericXmlApplicationContext로 모든 Bean 가져오기