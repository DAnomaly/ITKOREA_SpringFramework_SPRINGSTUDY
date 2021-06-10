# ex07_java_into_xml
  * JavaBean을 XmlBean에 추가하기

## app-context7.xml

1. AppContext.java는 annotation(@Configuration, @Bean)을 통해서   Bean을 생성하므로 ```<context:annotaion-config />``` 태그를 추가한다.  
작업 수행을 위해서 Namespaces 탭에서 context를 선택한다.
2. ```<bean class="AppContext"/>``` 태그를 추가한다.
```
예시>
<context:annotation-config/>
<bean class="ex07_java_into_xml.AppContext"/>
```