package ex04_xml;

public class BMICalculator {

	// field(property)
	// private double low; // 저체중(low < 20), normal 기준으로 처리하므로 불필요하다.
	private double normal; // 정상(20 <= normal < 25)
	private double over; // 과체중(25 <= over < 30)
	private double obesity; // 비만(30 <= obesity)
	private Calculator calculator;
	
	// constructor
	public BMICalculator() {
		// default
	}
	public BMICalculator(double normal, double over, double obesity, Calculator calculator) {
		super();
		this.normal = normal;
		this.over = over;
		this.obesity = obesity;
		this.calculator = calculator;
	}
	
	// method
	public void info(double height, double weight) {
		// 체질량지수 = 몸무게(kg) / 키(m)^2
		height = calculator.divide(height, 100);
		double bmi = calculator.divide(weight, calculator.multyply(height, height));
		
		// 상태 확인
		String health = "";
		if (bmi >= obesity) health = "비만";
		else if (bmi >= over) health = "과체중";
		else if (bmi >= normal) health = "정상";
		else health = "저체중";
		
		// 상태 출력
		System.out.println("체질량지수는 "+ bmi + "(BMI)이고, " + health + " 상태 입니다.");
	}
	
	// getter/setter
	public double getNormal() {
		return normal;
	}
	public void setNormal(double normal) {
		this.normal = normal;
	}
	public double getOver() {
		return over;
	}
	public void setOver(double over) {
		this.over = over;
	}
	public double getObesity() {
		return obesity;
	}
	public void setObesity(double obesity) {
		this.obesity = obesity;
	}
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
}
