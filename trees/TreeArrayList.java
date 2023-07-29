package trees;

import java.util.ArrayList;


public class TreeArrayList {
    private ArrayList<Integer> treeList;

    public TreeArrayList() {
        treeList = new ArrayList<>();
    }

    public void insert(int data) {
        treeList.add(data);
    }

    public void setLeftChild(int parentIndex, int data) {
        int leftChildIndex = 2 * parentIndex + 1;
        if (leftChildIndex >= treeList.size()) {
            for (int i = treeList.size(); i <= leftChildIndex; i++) {
                treeList.add(null); // Fill with null until the required index is reached
            }
        }
        treeList.set(leftChildIndex, data);
    }

    public void setRightChild(int parentIndex, int data) {
        int rightChildIndex = 2 * parentIndex + 2;
        if (rightChildIndex >= treeList.size()) {
            for (int i = treeList.size(); i <= rightChildIndex; i++) {
                treeList.add(null); // Fill with null until the required index is reached
            }
        }
        treeList.set(rightChildIndex, data);
    }

    public int getRoot() {
        if (!treeList.isEmpty()) {
            return treeList.get(0);
        }
        return -1; // Return -1 for an empty tree
    }

    public int getLeftChild(int parentIndex) {
        int leftChildIndex = 2 * parentIndex + 1;
        if (leftChildIndex < treeList.size()) {
            Integer leftChild = treeList.get(leftChildIndex);
            return leftChild != null ? leftChild : -1; // Return -1 if left child is null (not present)
        }
        return -1; // Return -1 for an invalid index
    }

    public int getRightChild(int parentIndex) {
        int rightChildIndex = 2 * parentIndex + 2;
        if (rightChildIndex < treeList.size()) {
            Integer rightChild = treeList.get(rightChildIndex);
            return rightChild != null ? rightChild : -1; // Return -1 if right child is null (not present)
        }
        return -1; // Return -1 for an invalid index
    }

    public Integer get(int index) {
        if (index >= 0 && index < treeList.size()) {
            return treeList.get(index);
        }
        return null; // Return null for invalid index
    }
    
    public static void main(String[] args) {
        TreeArrayList tree = new TreeArrayList();
        tree.insert(10);
        tree.setLeftChild(0, 5);
        tree.setRightChild(0, 15);
        tree.setLeftChild(1, 3);
        tree.setRightChild(1, 7);

        // Print the tree elements
        System.out.println("Root: " + tree.get(0));
        System.out.println("Left child of " + tree.get(0) + ": " + tree.getLeftChild(0));
        System.out.println("Right child of " + tree.get(0) + ": " + tree.getRightChild(0));
        System.out.println("Left child of " + tree.get(1) + ": " + tree.getLeftChild(1));
        System.out.println("Right child of " + tree.get(1) + ": " + tree.getRightChild(1));
    }

}
