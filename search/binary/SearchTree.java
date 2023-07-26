package search.binary;

import java.util.Random;

class BinarySearchTree {
    private int value;
    private int depth;
    private BinarySearchTree left;
    private BinarySearchTree right;

    public BinarySearchTree(int value, int depth) {
        this.value = value;
        this.depth = depth;
        this.left = null;
        this.right = null;
    }

    public void insert(int value) {
        if (value < this.value) {
            if (left == null) {
                // Create a new left node if it does not exist
                left = new BinarySearchTree(value, this.depth + 1);
                System.out.println("Tree node " + value + " added to the left of " + this.value + " at depth " + (this.depth + 1));
            } else {
                // Recursively insert into the left subtree
                left.insert(value);
            }
        } else {
            if (right == null) {
                // Create a new right node if it does not exist
                right = new BinarySearchTree(value, this.depth + 1);
                System.out.println("Tree node " + value + " added to the right of " + this.value + " at depth " + (this.depth + 1));
            } else {
                // Recursively insert into the right subtree
                right.insert(value);
            }
        }
    }

    public BinarySearchTree getNodeByValue(int value) {
        if (this.value == value) {
            // Return the current node if the value matches
            return this;
        } else if (left != null && value < this.value) {
            // Recursively search in the left subtree if value is less than current node's value
            return left.getNodeByValue(value);
        } else if (right != null && value >= this.value) {
            // Recursively search in the right subtree if value is greater than or equal to current node's value
            return right.getNodeByValue(value);
        } else {
            // Value not found, return null
            return null;
        }
    }

    public void depthFirstTraversal() {
        if (left != null) {
            // Perform depth-first traversal on the left subtree
            left.depthFirstTraversal();
        }
        // Print the current node's depth and value
        System.out.println("Depth=" + depth + ", Value=" + value);
        if (right != null) {
            // Perform depth-first traversal on the right subtree
            right.depthFirstTraversal();
        }
    }
}

public class SearchTree {
    public static void main(String[] args) {
        System.out.println("Creating Binary Search Tree rooted at value 15:");
        BinarySearchTree tree = new BinarySearchTree(15, 1);

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int value = random.nextInt(101);
            tree.insert(value);
        }

        System.out.println("Printing the inorder depth-first traversal:");
        tree.depthFirstTraversal();
    }
}
