package collections;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();

        // Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");

        // Display the ArrayList
        System.out.println("ArrayList: " + fruits);

        // Accessing elements
        String firstFruit = fruits.get(0);
        System.out.println("First fruit: " + firstFruit);

        // Modifying an element
        fruits.set(1, "Mango");
        System.out.println("Modified ArrayList: " + fruits);

        // Removing an element
        fruits.remove(0);
        System.out.println("ArrayList after removal: " + fruits);

        // Size and empty check
        int size = fruits.size();
        boolean isEmpty = fruits.isEmpty();
        System.out.println("Size: " + size);
        System.out.println("Is empty? " + isEmpty);

        // Checking existence
        boolean containsMango = fruits.contains("Mango");
        System.out.println("Contains 'Mango'? " + containsMango);

        // Adding elements at specific positions
        fruits.add(0, "Strawberry");
        fruits.add(2, "Grapes");
        System.out.println("ArrayList after adding: " + fruits);

        // Iterating over elements
        System.out.println("Iterating over elements:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // Sublist
        ArrayList<String> sublist = new ArrayList<>(fruits.subList(1, 3));
        System.out.println("Sublist: " + sublist);

        // Clear the ArrayList
        fruits.clear();
        System.out.println("ArrayList after clearing: " + fruits);
    }
}
