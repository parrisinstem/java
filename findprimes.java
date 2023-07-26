import java.util.ArrayList;

public class findprimes {
    public static void main(String[] args) {
        // Array of integers containing various numbers.
        int[] numbers = { 2, 3, 6, 7, 11, 13, 17, 19, 23, 29, 30, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };

        // ArrayList to store prime numbers found in the array.
        ArrayList<Integer> primes = getPrimeNumbers(numbers);

        // Print the prime numbers found in the array.
        System.out.println("Prime numbers in the array: " + primes);
    }

    // Method to check if a given number is prime or not.
    public static boolean isPrime(int number) {
        // A number less than or equal to 1 is not prime.
        if (number <= 1) {
            return false;
        }

        // Check for factors up to the square root of the number.
        for (int i = 2; i <number; i++) {
            // If the number is divisible by any value of 'i', it is not prime.
            if (number % i == 0) {
                return false;
            }
        }

        // If no factors are found up to the square root, the number is prime.
        return true;
    }

    // Method to find and return an ArrayList containing all the prime numbers from the input array.
    public static ArrayList<Integer> getPrimeNumbers(int[] numbers) {
        // Create an ArrayList to store the prime numbers.
        ArrayList<Integer> primes = new ArrayList<>();

        // Loop through each number in the input array.
        for (int number : numbers) {
            // Check if the current number is prime using the isPrime method.
            if (isPrime(number)) {
                // If the number is prime, add it to the primes ArrayList.
                primes.add(number);
            }
        }

        // Return the ArrayList containing all the prime numbers found in the input array.
        return primes;
    }
}
 

