/*
//FVCproductions
Purpose of this program is to test my concepts on inheritance as well as manipulation objects in an array.
In the program there's an application that manages a list of the Person class using an array classes using the subclasses Student and Faculty to assign values to each student's info.
*/

public class Student extends Person 
	
	{

	//define attributes that are protected
	//aka additional attributes for specific Student class
	
	protected String major;
	protected float gpa;
	
	String str2;
	
	//1st constructor
	
	public Student(String aFirstName, String aLastName, int aAge, double aMoney) 
	{
		
		super(aFirstName, aLastName, aAge, aMoney);
		
		/*
		name =aName;
		age = aAge;
		money = aMoney;
		*/
		
		major = "n/a";
		
	
	}
	
	//2nd constructor
	
	public Student(String aFirstName, String aLastName, int aAge, double aMoney, String aMajor, float aGPA) 
	{
		
		super(aFirstName, aLastName, aAge, aMoney);
		
		/*
		name =aName;
		age = aAge;
		money = aMoney;
		*/
		
		major = aMajor;
		
		gpa = aGPA;
	
	}
	
	public String getMajor() 
	{
		return major;
	}
	
	
	public float getGpa() 
	{
		return gpa;
	}
	
	public void setMajor(String aMajor)
	{
		major = aMajor;
	}
	
	public void setGpa(float aGPA)
	{
		gpa = aGPA;
	}
	
	public String toString() {
		
		/*
		if (major.equals("unknown")) {
			str2 = "F: " + super.toString() + "\t" + major;
			return str2;
		}
		
		else {
		*/
			str2 = "S: " + super.toString() + major + "\t";
			return str2;
		//}
	}

}
	