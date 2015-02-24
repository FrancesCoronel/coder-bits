import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.Scanner;

public class calcGrade {
	
	public static void main(String[] args) {

		double lab_grade = 0;
		double test_grade = 0;
		double quiz_grade = 0;
		double final_exam = 0;
		double final_grade = 0;

		Scanner scan = new Scanner(System.in);

		//lab assignments

		System.out.print("Enter your total lab assignment grade: ");
		lab_grade = scan.nextDouble();

		lab_grade *= .125; //12.5% of grade
		
		System.out.println();
		//quiz grades
		
		double[] quizzes = new double[8];
		
		for (int i = 1; i <= 8 ; i++) {
			System.out.print("Enter your quiz grade # " + i + ": ");
			quizzes[i-1] = scan.nextDouble();
		}
		
		double lowest_quiz = quizzes[0];
		
		for (int i = 1; i < quizzes.length; i++) {
			if (quizzes[i] < lowest_quiz)
				lowest_quiz = quizzes[i];
		}
		
		double quiz_sum = 0;
		
		for (double i: quizzes)
			quiz_sum += i;
			
		quiz_sum -= lowest_quiz;
		
		quiz_grade = quiz_sum;
		
		quiz_grade /= 7;
		quiz_grade *= .125; //12.5% of grade
		
		System.out.println();
		//test grades

		for (int i = 1; i <= 3; i++) {
			System.out.print("Enter your test grade # " + i + ": ");
			test_grade = scan.nextDouble();
			test_grade += test_grade;
		}

		test_grade /= 3;
		test_grade *= .45; //45% of grade

		System.out.println();
		//final exam

		System.out.print("Enter your final exam grade: ");
		final_exam = scan.nextDouble();

		final_exam *= .30; //30% of grade

		final_grade = lab_grade + quiz_grade + test_grade + final_exam;
		
		System.out.println("\n"+ final_grade);
		
		if (final_grade >= 72)
			System.out.println("YOU PASSED YOU LUCKY BASTARD");
		else
			System.out.println("NOOOOOOOOOOOOO");


		
	}
}