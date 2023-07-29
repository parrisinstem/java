package stacks;

public class StackArray {
    private int[] items;
    private int top; // Index of the top element in the stack
    private int maxSize;
    static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;

    public StackArray() {
        this(DEFAULT_MAX_SIZE);
    }

    public StackArray(int maxSize) {
        this.maxSize = maxSize;
        items = new int[maxSize];
        top = -1; // Initialize the top index to -1 to indicate an empty stack
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean hasSpace() {
        return top == maxSize - 1;
    }

    public void push(int item) {
        if (!hasSpace()) {
            top++;
            items[top] = item;
        } else {
            System.out.println("Stack is full. Cannot push " + item);
        }
    }

    public int pop() {
        if (!isEmpty()) {
            int poppedItem = items[top];
            top--;
            return poppedItem;
        } else {
            System.out.println("Stack is empty.");
            return -1; // Return a default value to indicate an empty stack
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return items[top];
        } else {
            System.out.println("Stack is empty.");
            return -1; // Return a default value to indicate an empty stack
        }
    }

    public int size() {
        return top + 1;
    }
}
