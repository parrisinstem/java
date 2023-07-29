package heaps;
import java.util.ArrayList;

public class MaxHeap {

    public ArrayList<Integer> heap;
    public int size;

    public MaxHeap() {
        this.heap = new ArrayList<Integer>();
        this.heap.add(null);
        this.size = 0;
    }

    public void add(int value) {
        this.heap.add(value);
        this.size++;
        this.bubbleUp();
    }

    public int popMax() {
        if (this.size == 0) {
            throw new Error("Heap is empty!");
        }
        this.swap(1, this.size);
        int max = this.heap.remove(this.size);
        this.size--;
        this.heapify();
        return max;
    }

    private void bubbleUp() {
        int current = this.size;
        while (current > 1 && this.heap.get(current) > this.heap.get(this.getParent(current))) {
            this.swap(current, this.getParent(current));
            current = this.getParent(current);
        }
    }

    private void heapify() {
        int current = 1;
        int leftChild = this.getLeft(current);
        int rightChild = this.getRight(current);

        while (this.canSwap(current, leftChild, rightChild)) {
            int largerChild = leftChild;
            if (this.exists(rightChild) && this.heap.get(rightChild) > this.heap.get(leftChild)) {
                largerChild = rightChild;
            }

            if (this.heap.get(current) < this.heap.get(largerChild)) {
                this.swap(current, largerChild);
                current = largerChild;
            } else {
                break;
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
        return (this.exists(leftChild) && this.heap.get(current) < this.heap.get(leftChild))
                || (this.exists(rightChild) && this.heap.get(current) < this.heap.get(rightChild));
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

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();

        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(15);
        maxHeap.add(3);
        maxHeap.add(7);

        System.out.print("Max Heap elements: ");
        while (maxHeap.size > 0) {
            System.out.print(maxHeap.popMax() + " "); // Output: 15 10 7 5 3
        }
        System.out.println();
    }
}
