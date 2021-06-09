# ex03_xml
 참고:   
 >../resources/ex01_xml/app-context3-1.xml  
 >../resources/ex01_xml/app-context3-2.xml  
 >../resources/ex01_xml/app-context3-3.xml  
 * List - property
 * Set - property
 * Map - property

## List
```
<bean id="객체명" class="클래스명">
	<property name="필드명">
		<list>
			<value>값1</value>
			<value>값2</value>
			<value>값3</value>
		</list>
	</property>
</bean>
```
## Set
```
<bean id="객체명" class="클래스명">
	<property name="필드명">
		<set>
			<value>값1</value>
			<value>값2</value>
			<value>값3</value>
		</set>
	</property>
</bean>
```
## Map
```
<bean id="객체명" class="클래스명">
	<property name="필드명">
		<map>
			<entry key="키1" value="값1"/>
			<entry key="키2" value="값2"/>
			<entry key="키3" value="값3"/>
		</map>
	</property>
</bean>
```