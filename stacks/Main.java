package stacks;

    public class Main {
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek()); // Output: Top element: 30

        System.out.println("Popped item: " + stack.pop()); // Output: Popped item: 30
        System.out.println("Popped item: " + stack.pop()); // Output: Popped item: 20

        System.out.println("Is the stack empty? " + stack.isEmpty()); // Output: Is the stack empty? false
        System.out.println("Stack size: " + stack.size()); // Output: Stack size: 1
    }
}

    



