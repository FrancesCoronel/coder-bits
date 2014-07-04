//FVCproductions
//Lab 4
//Program Name: Constructor_Fcoronel.java
//Date: February 20, 2014
//Description: Chapter 3

public class Constructor_FCoronel {
	//defining variables privately
	private String student;
	private String course;
	private int midGrade;
	//creating constructor
	public Constructor_FCoronel(String stName, String crseName) 
	{
	student = stName;
	course = crseName;
	midGrade = 10;
	}
	//mutator methods
	public void setStname(String stName) {
	student = stName;
	}
	
	public void setCrseName(String crseName) {
	course = crseName;
	}
	//accessor methods
	public String getStname() {
	return student;
	}
	
	public String getCrseName() {
	return course;
	}
	//calculated method
	public int calcMidGrade() {
	midGrade = midGrade * 10 + 4;
	return midGrade;
	}
	
	//yay - extra credit
	public Constructor_FCoronel() {
	midGrade = 20;
	}
	
}