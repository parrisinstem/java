package classes;

public class Main {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2); // Output: true (both references point to the same instance)

        singleton1.doSomething(); // Output: Singleton class is doing something.
    }
}
