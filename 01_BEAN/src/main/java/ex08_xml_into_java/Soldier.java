package ex08_xml_into_java;

import java.util.Map;
import java.util.Set;

public class Soldier {

	private String name;
	private Gun gun;
	private Map<String, String> army;
	
	public Soldier() {}
	public Soldier(String name, Gun gun, Map<String, String> army) {
		super();
		this.name = name;
		this.gun = gun;
		this.army = army;
	}

	public void info() {
		System.out.println("이름: " + name);
		System.out.println("총기모델: " + gun.getModel());
		System.out.println("총알수: " + gun.getBullet());
		Set<String> keys = army.keySet();
		for(String key : keys) {
			System.out.println(key + ": " + army.get(key));
		}
	}
	
	public String getName() {
		return name;
	}
	public Gun getGun() {
		return gun;
	}
	public Map<String, String> getArmy() {
		return army;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setGun(Gun gun) {
		this.gun = gun;
	}
	public void setArmy(Map<String, String> army) {
		this.army = army;
	}
	
	
}
