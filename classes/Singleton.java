package classes;

public class Singleton {
    // Private static instance variable to hold the single instance of the class
    private static Singleton instance;

    // Private constructor to prevent external instantiation
    private Singleton() {
        // Initialization code, if any
    }

    // Public static method to access the single instance of the class
    public static Singleton getInstance() {
        // If the instance has not been created yet, create it
        if (instance == null) {
            instance = new Singleton();
        }
        // Return the single instance of the class
        return instance;
    }

    // Other methods and attributes of the class can be added below
    public void doSomething() {
        System.out.println("Singleton class is doing something.");
    }
}
