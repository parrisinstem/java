package queues;


public class PriorityQueue {
    private int[] heapArray;
    private int maxSize;
    private int currentSize;

    public PriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        this.heapArray = new int[maxSize + 1]; // We use index 0 as a dummy element
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public void enqueue(int item) {
        if (isFull()) {
            throw new RuntimeException("Priority queue is full.");
        }

        currentSize++;
        int index = currentSize; // Start from the last element

        // Bubble up the new element to its correct position based on priority
        while (index > 1 && item < heapArray[index / 2]) {
            heapArray[index] = heapArray[index / 2];
            index /= 2;
        }

        heapArray[index] = item;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty.");
        }

        int root = heapArray[1];
        heapArray[1] = heapArray[currentSize];
        currentSize--;

        // Bubble down the root element to its correct position based on priority
        int index = 1;
        while (index * 2 <= currentSize) {
            int childIndex = index * 2;
            // Find the smaller child if it exists
            if (childIndex < currentSize && heapArray[childIndex] > heapArray[childIndex + 1]) {
                childIndex++;
            }
            // If the root is already smaller than both children, break
            if (heapArray[index] <= heapArray[childIndex]) {
                break;
            }
            // Swap root with the smaller child and continue
            int temp = heapArray[index];
            heapArray[index] = heapArray[childIndex];
            heapArray[childIndex] = temp;
            index = childIndex;
        }

        return root;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Priority queue is empty.");
        }
        return heapArray[1];
    }
}
