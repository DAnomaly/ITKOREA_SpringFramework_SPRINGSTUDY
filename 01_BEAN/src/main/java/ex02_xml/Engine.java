package ex02_xml;

public class Engine {
	
	// field
	private String type; // 가솔린, 디젤
	private int cc; // 배기량
	private int hp; // 마력
	private double efficiency; // 연비
	
	// constructor
	public Engine() {
		
	}
	public Engine(String type, int cc, int hp, double efficiency) {
		super();
		this.type = type;
		this.cc = cc;
		this.hp = hp;
		this.efficiency = efficiency;
	}
	
	// getter/setter
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public double getEfficiency() {
		return efficiency;
	}
	public void setEfficiency(double efficiency) {
		this.efficiency = efficiency;
	}
	
	// method
	public void info() {
		System.out.println("엔진타입: " + type);
		System.out.println("배기량: " + cc + "cc");
		System.out.println("마력: " + hp + "hp");
		System.out.println("연비: " + efficiency + "km/l");
	}
	
	
}
