package trees;

public class ArrayBinaryTree {
    private int[] treeArray;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayBinaryTree() {
        treeArray = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    // Method to get the index of the parent node
    private int parentIndex(int index) {
        return (index - 1) / 2;
    }

    // Method to get the index of the left child node
    private int leftChildIndex(int index) {
        return 2 * index + 1;
    }

    // Method to get the index of the right child node
    private int rightChildIndex(int index) {
        return 2 * index + 2;
    }

    // Method to check if a node has a left child
    private boolean hasLeftChild(int index) {
        return leftChildIndex(index) < size;
    }

    // Method to check if a node has a right child
    private boolean hasRightChild(int index) {
        return rightChildIndex(index) < size;
    }

    // Method to insert a new element into the tree
    public void insert(int value) {
        if (size == treeArray.length) {
            resizeArray();
        }

        treeArray[size] = value;
        size++;
    }

    // Method to resize the underlying array when needed
    private void resizeArray() {
        int newCapacity = treeArray.length * 2;
        int[] newArray = new int[newCapacity];
        System.arraycopy(treeArray, 0, newArray, 0, treeArray.length);
        treeArray = newArray;
    }

    // Method to perform in-order traversal of the tree
    public void inOrderTraversal() {
        inOrderTraversal(0);
    }

    private void inOrderTraversal(int index) {
        if (index >= size) {
            return;
        }

        inOrderTraversal(leftChildIndex(index));
        System.out.print(treeArray[index] + " ");
        inOrderTraversal(rightChildIndex(index));
    }

    // Method to perform pre-order traversal of the tree
    public void preOrderTraversal() {
        preOrderTraversal(0);
    }

    private void preOrderTraversal(int index) {
        if (index >= size) {
            return;
        }

        System.out.print(treeArray[index] + " ");
        preOrderTraversal(leftChildIndex(index));
        preOrderTraversal(rightChildIndex(index));
    }

    // Method to perform post-order traversal of the tree
    public void postOrderTraversal() {
        postOrderTraversal(0);
    }

    private void postOrderTraversal(int index) {
        if (index >= size) {
            return;
        }

        postOrderTraversal(leftChildIndex(index));
        postOrderTraversal(rightChildIndex(index));
        System.out.print(treeArray[index] + " ");
    }
    public static void main(String[] args) {
        ArrayBinaryTree binaryTree = new ArrayBinaryTree();
        binaryTree.insert(10);
        binaryTree.insert(5);
        binaryTree.insert(15);
        binaryTree.insert(3);
        binaryTree.insert(7);

        System.out.print("In-order traversal: ");
        binaryTree.inOrderTraversal(); // Output: 3 5 7 10 15
        System.out.println();

        System.out.print("Pre-order traversal: ");
        binaryTree.preOrderTraversal(); // Output: 10 5 3 7 15
        System.out.println();

        System.out.print("Post-order traversal: ");
        binaryTree.postOrderTraversal(); // Output: 3 7 5 15 10
        System.out.println();
    }
}
