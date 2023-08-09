package collections;

import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // Create a LinkedList of Integers
        LinkedList<Integer> numbers = new LinkedList<>();

        // Adding elements
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);

        // Display the LinkedList
        System.out.println("LinkedList: " + numbers);

        // Accessing elements
        int firstNumber = numbers.getFirst();
        int lastNumber = numbers.getLast();
        System.out.println("First number: " + firstNumber);
        System.out.println("Last number: " + lastNumber);

        // Modifying an element
        numbers.set(1, 25);
        System.out.println("Modified LinkedList: " + numbers);

        // Removing elements
        numbers.removeFirst();
        numbers.removeLast();
        System.out.println("LinkedList after removal: " + numbers);

        // Size and empty check
        int size = numbers.size();
        boolean isEmpty = numbers.isEmpty();
        System.out.println("Size: " + size);
        System.out.println("Is empty? " + isEmpty);

        // Checking existence
        boolean contains25 = numbers.contains(25);
        System.out.println("Contains 25? " + contains25);

        // Adding elements at specific positions
        numbers.addFirst(5);
        numbers.addLast(35);
        System.out.println("LinkedList after adding: " + numbers);

        // Iterating over elements
        System.out.println("Iterating over elements:");
        for (int number : numbers) {
            System.out.println(number);
        }

        // Clear the LinkedList
        numbers.clear();
        System.out.println("LinkedList after clearing: " + numbers);
    }
}
