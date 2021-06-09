package ex03_xml;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapBean {

	// field(property)
	private Map<String, String> map;

	// contructor
	// 디폴트
	
	// method
	public void info() {
		for (Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	// getter/setter
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
	
	
}
