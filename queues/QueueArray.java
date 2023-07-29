package queues;


public class QueueArray {
    private int[] items;
    private int front; // Index of the front element in the queue
    private int rear; // Index of the rear element in the queue
    private int size; // Current number of elements in the queue
    public static final int DEFAULT_MAX_SIZE = Integer.MAX_VALUE;

    public QueueArray() {
        this(DEFAULT_MAX_SIZE);
    }

    public QueueArray(int maxSize) {
        this.items = new int[maxSize];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == items.length;
    }

    public void enqueue(int item) {
        if (!isFull()) {
            rear = (rear + 1) % items.length; // Circular increment of rear index
            items[rear] = item;
            size++;
            if (front == -1) {
                front = rear; // If the queue was empty, set front to the new element
            }
        } else {
            System.out.println("Queue is full. Cannot enqueue " + item);
        }
    }

    public int dequeue() {
        if (!isEmpty()) {
            int dequeuedItem = items[front];
            front = (front + 1) % items.length; // Circular increment of front index
            size--;
            if (isEmpty()) {
                front = -1; // If the queue becomes empty after dequeuing, reset front and rear
                rear = -1;
            }
            return dequeuedItem;
        } else {
            System.out.println("Queue is empty.");
            return -1; // Return a default value to indicate an empty queue
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return items[front];
        } else {
            System.out.println("Queue is empty.");
            return -1; // Return a default value to indicate an empty queue
        }
    }

    public int size() {
        return size;
    }
}

