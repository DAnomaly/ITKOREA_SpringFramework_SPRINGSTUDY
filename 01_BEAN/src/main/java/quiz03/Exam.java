package quiz03;

import java.util.List;

public class Exam {
	
	// field
	private List<Integer> scores; // 5개의 점수
	private double average; // 평균
	private char grade; // A ~ F
	
	// constructor
	public Exam(List<Integer> scores) {
		this.scores = scores;
		int total = 0;
		for (int score : scores) {
			total += score;
		}
		this.average = (double) total / scores.size();
		switch ((int)(this.average / 10)) {
		case 10:
		case 9:
			this.grade = 'A';
			break;
		case 8:
			this.grade = 'B';
			break;
		case 7:
			this.grade = 'C';
			break;
		case 6:
			this.grade = 'D';
			break;
		default:
			this.grade = 'F';
			break;
		}
	}
	
	// method
	public void info() {
		System.out.println("scores: " + scores.toString());
		System.out.println("average: " + average);
		System.out.println("grade: " + grade);
	}
	public List<Integer> getScores() {
		return scores;
	}
	public double getAverage() {
		return average;
	}
	public char getGrade() {
		return grade;
	}
	
}
