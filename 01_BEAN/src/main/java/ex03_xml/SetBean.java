package ex03_xml;

import java.util.Iterator;
import java.util.Set;

public class SetBean {

	// field(property)
	private Set<String> set;

	// constructor
	public SetBean() {}
	
	// method
	public void info() {
		/*
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		*/
		for (String str : set) {
			System.out.println(str);
		}
	}
	
	// getter/setter
	public Set<String> getSet() {
		return set;
	}
	public void setSet(Set<String> set) {
		this.set = set;
	}
	
	
}
