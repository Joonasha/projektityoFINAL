package HelperClasses;

public class ChartSubject {
	String name;
	int grade;
	int value;
	int repeat;
	
	public ChartSubject() {
		name = "Asd";
		value = 1;
		repeat = 1;
	}

	public ChartSubject(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public ChartSubject(String name, int value, int grade) {
		this.name = name;
		this.value = value;
		this.grade = grade;
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public ChartSubject(int grade, int value) {
		this.grade=grade;
		this.value=value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getRepeat() {
		return repeat;
	}
	public void setRepeat(int repeat) {
		this.repeat = repeat;
	}
	
}

