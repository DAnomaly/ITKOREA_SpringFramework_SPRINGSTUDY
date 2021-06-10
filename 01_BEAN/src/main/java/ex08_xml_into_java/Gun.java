package ex08_xml_into_java;

public class Gun {

	private String model;
	private int bullet;
	
	public Gun() {}
	public Gun(String model, int bullet) {
		super();
		this.model = model;
		this.bullet = bullet;
	}
	
	public String getModel() {
		return model;
	}
	public int getBullet() {
		return bullet;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
}
