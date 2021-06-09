package ex03_xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMainClass {

	public static void main(String[] args) {
		
		String resourceLoctaion1 = "ex03_xml/app-context3-1.xml";
		String resourceLoctaion2 = "ex03_xml/app-context3-2.xml";
		String resourceLoctaion3 = "ex03_xml/app-context3-3.xml";
		AbstractApplicationContext ctx1 = new GenericXmlApplicationContext(resourceLoctaion1,resourceLoctaion2,resourceLoctaion3);
		
		System.out.println("-----ListBean-----");
		ListBean listBean = ctx1.getBean("listBean",ListBean.class);
		listBean.info();
		
		System.out.println("-----SetBean-----");
		SetBean setBean = ctx1.getBean("setBean",SetBean.class);
		setBean.info();
		
		System.out.println("-----MapBean-----");
		MapBean mapBean = ctx1.getBean("mapBean",MapBean.class);
		mapBean.info();
		
		ctx1.close();
		
	}
}
