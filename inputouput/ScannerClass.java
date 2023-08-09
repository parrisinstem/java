package inputouput;

// Java Program to show how to take
// input from user using Scanner Class

import java.util.*;

public class ScannerClass{

	public static void main(String[] args)
	{
		try (// Scanner definition
		Scanner obj = new Scanner(System.in)) {
			
		String name;
		int rollno;
		float marks;
		System.out.println("Enter your name");
		name = obj.nextLine(); // taking string input
		System.out.println("Enter your rollno");
		rollno = obj.nextInt(); // taking integer input
		System.out.println("Enter your marks");
		marks = obj.nextFloat(); // taking float input
		// printing the output
		System.out.println("Name=" + name);
		System.out.println("Rollno=" + rollno);
		System.out.println("Marks=" + marks);
		}
	}
}
