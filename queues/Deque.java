package queues;

public class Deque<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    private static class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Deque() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E item) {
        Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    public void addLast(E item) {
        Node<E> newNode = new Node<>(item);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty.");
        }

        E removedItem = front.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        size--;
        return removedItem;
    }

    public E removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty.");
        }

        E removedItem = rear.data;
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        size--;
        return removedItem;
    }

    public E peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty.");
        }
        return front.data;
    }

    public E peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Deque is empty.");
        }
        return rear.data;
    }

    public int size() {
        return size;
    }
}

