package operators;

// Java program to find largest among two
// numbers using ternary operator

public class Ternary {
	public static void main(String[] args)
	{

		// variable declaration
		int n1 = 5, n2 = 10, max;

		System.out.println("First num: " + n1);
		System.out.println("Second num: " + n2);

		// Largest among n1 and n2
		max = (n1 > n2) ? n1 : n2;

		// Print the largest number
		System.out.println("Maximum is = " + max);

        int num = 7;

        // Nested if-else version
        String resultNestedIfElse;
        if (num > 0) {
            if (num % 2 == 0) {
                resultNestedIfElse = "Positive even number";
            } else {
                resultNestedIfElse = "Positive odd number";
            }
        } else {
            resultNestedIfElse = "Non-positive number";
        }

        // Ternary version
        String resultTernary = num > 0 ? (num % 2 == 0 ? "Positive even number" : "Positive odd number") : "Non-positive number";

        System.out.println("Nested if-else result: " + resultNestedIfElse);
        System.out.println("Ternary result: " + resultTernary);
	}
}
