/*
FVCproductions
Resolution Proofs
Program 2
Written in Java
*/


/*
 
Resolution is a proof technique proposed by J.A. Robinson in 1965, that depends on a single rule:

		If p ∨ q and ¬p ∨ r are both true,
		then q ∨ r is true.
 
Write a program that constructs the Truth Table for Resolution Proofs. Declare variables p, q, and r as boolean variables, then for each row assign each variable true or false as needed.  For example:
 
// Table Row for true true true

p = true; q = true; r = true;
System.out.println(p + "\t" + q + "\t" + r + "\t\t" + (p | q) + "\t\t" + (!p | r) + "\t\t" + (q | r));

*/

public class ResolutionProofs {

	public static void main(String[] args) {

		System.out.println("\nResolution Proofs\n");
		System.out.println("if if (p | q) and (!p | r) are both true,");
		System.out.println("then (q | r) is true.\n");

		System.out.println("p\tq\tr\t\tp | q\t\t!p | r\t\tq | r\n");

		// for p = true, q = true, and r = true

		boolean p = true; boolean q = true; boolean r = true;
		
		System.out.println(p + "\t" + q + "\t" + r + "\t\t" + (p | q) + "\t\t" + (!p | r) + "\t\t" + (q | r));

		// for p = true, q = true, and r = false
		
		p = true; q = true;  r = false;
				
		System.out.println(p + "\t" + q + "\t" + r + "\t\t" + (p | q) + "\t\t" + (!p | r) + "\t\t" + (q | r));

		// for p = true, q = false, and r = true
		
		 p = true;  q = false;  r = true;
				
		System.out.println(p + "\t" + q + "\t" + r + "\t\t" + (p | q) + "\t\t" + (!p | r) + "\t\t" + (q | r));

		// for p = true, q = false, and r = false
		
		 p = true;  q = false;  r = false;
				
		System.out.println(p + "\t" + q + "\t" + r + "\t\t" + (p | q) + "\t\t" + (!p | r) + "\t\t" + (q | r));

		// for p = false, q = true, and r = true
		
		 p = false;  q = true;  r = true;
				
		System.out.println(p + "\t" + q + "\t" + r + "\t\t" + (p | q) + "\t\t" + (!p | r) + "\t\t" + (q | r));
		
		// for p = false, q = true, and r = false
		
		 p = false;  q = true;  r = false;
				
		System.out.println(p + "\t" + q + "\t" + r + "\t\t" + (p | q) + "\t\t" + (!p | r) + "\t\t" + (q | r));
		
		// for p = false, q = false, and r = true
		
		 p = false;  q = false;  r = true;
				
		System.out.println(p + "\t" + q + "\t" + r + "\t\t" + (p | q) + "\t\t" + (!p | r) + "\t\t" + (q | r));
		
		// for p = false, q = false, and r = false
		
		 p = false;  q = false;  r = false;
						
		System.out.println(p + "\t" + q + "\t" + r + "\t\t" + (p | q) + "\t\t" + (!p | r) + "\t\t" + (q | r));
		
		System.out.println("\n");

	}
}