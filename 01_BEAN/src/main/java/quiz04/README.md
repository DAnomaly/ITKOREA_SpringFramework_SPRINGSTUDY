# quiz04

##  구현

### Lecture.java
```
private String name;
private String professor;
```
### Student.java
```
private String name;
private Lecture lecture;
```

### CONTEXT
quiz04.xml 에서 Lecture, Student 각 1개  
AppContext.java 에서 Lecture, Student 각 1개  
quiz04.xml 에서 AppContext.java 불러오기  
GenericXmlApplicationContext로 모든 Bean 가져오기