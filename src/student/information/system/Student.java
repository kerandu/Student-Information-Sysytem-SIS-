package student.information.system;

public class Student {

private String regno, name, gender, department, courseid, program, grade;
private int unit1, unit2, unit3, unit4, unit5, unit6, unit7, total, year;
private float average;

public Student  () {}

//when adding a student to database
public Student(String regno, String name, String gender, String department, String courseid, String program, int year) {
super();
this.regno = regno;
this.name = name;
this.courseid = courseid;
this.gender = gender;
this.department = department;
this.courseid = courseid;
this.program = program;
this.year = year;
}

//also to be used in updating student marks
public Student(String regno, String name, String courseid, int unit1, int unit2, int unit3, int unit4, int unit5, int unit6, int unit7, int total, float average, String grade) {
super();
this.regno = regno;
this.name = name;
this.courseid = courseid;
this.unit1 = unit1;
this.unit2 = unit2;
this.unit3 = unit3;
this.unit4 = unit4;
this.unit5 = unit5;
this.unit6 = unit6;
this.unit7 = unit7;
this.total = total;
this.average = average;
this.grade = grade;
}


//General input
public void student (){} 
	public Student(String regno, String name, String gender, String department, String courseid, String program, String grade, int unit1, 
			int unit2, int unit3, int unit4, int unit5, int unit6, int unit7, int year, int total, float average) {
	super();
	this.regno = regno;
	this.name = name;
	this.courseid = courseid;
	this.gender = gender;
	this.department = department;
	this.courseid = courseid;
	this.program = program;
	this.grade = grade;
	this.unit1 = unit1;
	this.unit2 = unit2;
	this.unit3 = unit3;
	this.unit4 = unit4;
	this.unit5 = unit5;
	this.unit6 = unit6;
	this.unit7 = unit7;
	this.total = total;
	this.average = average;
	this.year = year;
}
	
public String getRegno() {
	return regno;
}
public void setRegno(String regno) {
	this.regno = regno;
	}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getDepartment() {
	return department;
}
public void setDepartment(String department) {
	this.department = department;
}
public String getCourseid() {
	return courseid;
}
public void setCourseid(String courseid) {
	this.courseid = courseid;
}
public String getProgram() {
	return program;
}
public void setProgram(String program) {
	this.program = program;
}
public int getUnit1() {
	return unit1;
}
public void setUnit1(int unit1) {
	this.unit1 = unit1;
}
public int getUnit2() {
	return unit2;
}
public void setUnit2(int unit2) {
	this.unit2= unit2;
}
public int getUnit3() {
	return unit3;
}
public void setUnit3(int unit3) {
	this.unit3 = unit3;
}
public int getUnit4() {
	return unit4;
}
public void setUnit4(int unit4) {
	this.unit4 = unit4;
}
public int getUnit5() {
	return unit5;
}
public void setUnit5(int unit5) {
	this.unit5 = unit5;
}
public int getUnit6() {
	return unit6;
}
public void setUnit6(int unit6) {
	this.unit6 = unit6;
}
public int getUnit7() {
	return unit7;
}
public void setUnit7(int unit7) {
	this.unit7 = unit7;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public float getAverage() {
	return average;
}
public void setAverage(float average) {
	this.average = average;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}

}