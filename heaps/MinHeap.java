package heaps;
import java.util.ArrayList;
import java.util.Random;
public class MinHeap {

    public ArrayList<Integer> heap;
    public int size;

    public MinHeap() {
        this.heap = new ArrayList<Integer>();
        this.heap.add(null);
        this.size = 0;
    }

    public void add(int value) {
        this.heap.add(value);
        this.size++;
        this.bubbleUp();
    }

    public int popMin() {
        if (this.size == 0) {
            throw new Error("Heap is empty!");
        }
        this.swap(1, this.size);
        int min = this.heap.remove(this.size);
        this.size--;
        this.heapify();
        return min;
    }

    private void bubbleUp() {
        int current = this.size;
        while (current > 1 && this.heap.get(current) < this.heap.get(this.getParent(current))) {
            this.swap(current, this.getParent(current));
            current = this.getParent(current);
        }
    }

    private void heapify() {
        int current = 1;
        int leftChild = this.getLeft(current);
        int rightChild = this.getRight(current);

        while (this.canSwap(current, leftChild, rightChild)) {
            if (this.exists(leftChild) && this.exists(rightChild)) {
                if (this.heap.get(leftChild) < this.heap.get(rightChild)) {
                    this.swap(current, leftChild);
                    current = leftChild;
                } else {
                    this.swap(current, rightChild);
                    current = rightChild;
                }
                
            } else {
                this.swap(current,leftChild);
                current = leftChild;
            }
            leftChild = this.getLeft(current);
            rightChild = this.getRight(current);
        }
    }

    private void swap(int a, int b) {
        int temp = this.heap.get(b);
        this.heap.set(b, this.heap.get(a));
        this.heap.set(a, temp);
    }

    private boolean exists(int index) {
        return index <= this.size;
    }

    private boolean canSwap(int current, int leftChild, int rightChild) {
        return (this.exists(leftChild) && (this.heap.get(current) > this.heap.get(leftChild)))
                || (this.exists(rightChild) && (this.heap.get(current) > this.heap.get(rightChild)));
    }

    public int getParent(int current) {
        return (int) Math.floor(current / 2);
    }

    public int getLeft(int current) {
        return current * 2;
    }

    public int getRight(int current) {
        return (current * 2) + 1;
    }

     public static void main(String[]args) {
        MinHeap minHeap = new MinHeap();

        // Populate minHeap with 6 random numbers
        Random r = new Random();
        for (int i = 0; i < 6; i++) {
            int int_random = r.nextInt(101);
            System.out.println("Adding value " + int_random);
            minHeap.add(int_random);
            System.out.println("Content of min-heap: " + minHeap.heap);
        }
        
        System.out.println("----------");
        
        // Return the minimum value in the heap until the heap is empty
        for (int i = 0; i < 6; i++) {
            System.out.println("Removing minimum value " + minHeap.popMin());
            System.out.println("Content of min-heap: " + minHeap.heap);
        }


    }
}