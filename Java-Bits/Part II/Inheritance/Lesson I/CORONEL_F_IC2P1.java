// inclass 2, P1

public class CORONEL_F_IC2P1{	public static void main(String [] args)	{		
		// create a Person object P1 with first constructor & show information
		Person P1 = new Person("Fran", 18);		System.out.println("Person  P1: " + P1); 				// create a Person object P2 with second constructor& show information
		Person P2 = new Person("Dr.M", 20, 250.75);		System.out.println("Person  P2: " + P2);				// create a Student object S1 with first constructor & show information
		
		Student S1 = new Student("Tarzan", 18, 350.00);		System.out.println("Student S1: " + S1);				// create a Student object S2  with second constructor & show information
		
		Student S2 = new Student("Jane", 18, 300.00, "Biology", 4);		System.out.println("Student S2: " + S2);				// create a Faculty object F1 first constructor & show information
		
		Faculty F1 = new Faculty("Mr.B", 35, 450.00);		System.out.println("Faculty F1: " + F1);				// create a Faculty object F2  with second constructor & show information		
		Faculty F2 = new Faculty("Dr.Lex", 45, 567.00, "Chair", "Chemistry");		System.out.println("Faculty F2: " + F2);		}}