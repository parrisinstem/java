package heaps;

public class MinHeapArray {
    private int[] heap;
    private int size;
    private int maxSize;

    public MinHeapArray(int maxSize) {
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

    public int extractMin() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty.");
        }

        int min = heap[1];
        heap[1] = heap[size];
        size--;
        heapify(1);
        return min;
    }

    private void bubbleUp(int index) {
        while (index > 1 && heap[index] < heap[parent(index)]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void heapify(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left <= size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right <= size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
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
        MinHeapArray minHeap = new MinHeapArray(10);

        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(15);
        minHeap.insert(3);
        minHeap.insert(7);

        System.out.print("Min Heap elements: ");
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.extractMin() + " "); // Output: 3 5 7 10 15
        }
        System.out.println();
    }
}

