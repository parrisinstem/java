package heaps;

public class MaxHeapArray {
    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeapArray(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[maxSize + 1]; // We use index 0 for convenience
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException("Heap is full.");
        }

        size++;
        heap[size] = value;
        bubbleUp(size);
    }

    public int extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }

        int max = heap[1];
        heap[1] = heap[size];
        size--;
        heapify(1);
        return max;
    }

    private void bubbleUp(int index) {
        while (index > 1 && heap[index] > heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void heapify(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left <= size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right <= size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }



    // Increase the value of a key at a specific index in the max heap
    public void increaseKey(int index, int newKey) {
        if (index <= 0 || index > size) {
            throw new IllegalArgumentException("Invalid index.");
        }

        if (newKey < heap[index]) {
            throw new IllegalArgumentException("New key is smaller than the current key.");
        }

        heap[index] = newKey;
        bubbleUp(index);
    }

    // Delete a key at a specific index from the max heap
    public void deleteKey(int index) {
        if (index <= 0 || index > size) {
            throw new IllegalArgumentException("Invalid index.");
        }

        heap[index] = Integer.MAX_VALUE; // Set the key to a very large value
        bubbleUp(index);
        extractMax();
    }


    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return 2 * index;
    }

    private int rightChild(int index) {
        return 2 * index + 1;
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    public static void main(String[] args) {
        MaxHeapArray maxHeap = new MaxHeapArray(10);

        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(15);
        maxHeap.insert(3);
        maxHeap.insert(7);

        System.out.print("Max Heap elements: ");
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.extractMax() + " "); // Output: 15 10 7 5 3
        }
        System.out.println();
    }
}
