package queues;
import java.util.PriorityQueue;
import java.util.ArrayDeque;
import java.util.Deque;


public class Main {
    public static void main(String[] args) {
        QueueArray queue = new QueueArray(5); // Create a queue with a maximum size of 5
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(); // Create a priority queue of integers
        Deque<Integer> deque = new ArrayDeque<>(); // Create a double-ended queue of integers

    
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front element: " + queue.peek()); // Output: Front element: 10

        System.out.println("Dequeued item: " + queue.dequeue()); // Output: Dequeued item: 10
        System.out.println("Dequeued item: " + queue.dequeue()); // Output: Dequeued item: 20

        System.out.println("Is the queue empty? " + queue.isEmpty()); // Output: Is the queue empty? false
        System.out.println("Queue size: " + queue.size()); // Output: Queue size: 1

         // Enqueue elements with priority
        priorityQueue.add(30); // Priority 30
        priorityQueue.add(10); // Priority 10
        priorityQueue.add(50); // Priority 50
        priorityQueue.add(20); // Priority 20

        // Dequeue elements (in priority order)
        while (!priorityQueue.isEmpty()) {
            System.out.println("Dequeued item: " + priorityQueue.poll());
        }
         // Enqueue elements at the rear (end)
         deque.offerLast(10);
         deque.offerLast(20);
         deque.offerLast(30);
 
         // Enqueue elements at the front (start)
         deque.offerFirst(5);
         deque.offerFirst(2);
 
         // Dequeue elements from the rear (end)
         while (!deque.isEmpty()) {
             System.out.println("Dequeued item from the rear: " + deque.pollLast());
         }
    }
}
