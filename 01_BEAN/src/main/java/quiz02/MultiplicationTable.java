package quiz02;

public class MultiplicationTable {

	// field(property)
	private int startDan;
	private int endDan;
	private int startNum;
	private int endNum;
	private Calculator calculator;
	
	// constructor
	// 디폴트

	// method
	// getter/setter
	public int getStartDan() {
		return startDan;
	}
	public void setStartDan(int startDan) {
		this.startDan = startDan;
	}
	public int getEndDan() {
		return endDan;
	}
	public void setEndDan(int endDan) {
		this.endDan = endDan;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public void info() {
		for (int dan = startDan; dan <= endDan; dan++) {
			for (int num = startNum; num <= endNum; num++) {
				System.out.print(dan + "x" + num + "=" + calculator.multiply(dan, num) + " ");
			}
			System.out.println();
		}
		
	}
	
}
