package trees;

// Binary Tree class
public class BinaryTree {
    private BinaryTreeNode root;

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private BinaryTreeNode insertRecursive(BinaryTreeNode current, int data) {
        if (current == null) {
            return new BinaryTreeNode(data);
        }

        if (data < current.data) {
            current.left = insertRecursive(current.left, data);
        } else if (data > current.data) {
            current.right = insertRecursive(current.right, data);
        }

        return current;
    }

    public void inOrderTraversal() {
        inOrderTraversalRecursive(root);
    }

    private void inOrderTraversalRecursive(BinaryTreeNode node) {
        if (node != null) {
            inOrderTraversalRecursive(node.left);
            System.out.print(node.data + " ");
            inOrderTraversalRecursive(node.right);
        }
    }

    public void preOrderTraversal() {
        preOrderTraversalRecursive(root);
    }

    private void preOrderTraversalRecursive(BinaryTreeNode node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrderTraversalRecursive(node.left);
            preOrderTraversalRecursive(node.right);
        }
    }

    public void postOrderTraversal() {
        postOrderTraversalRecursive(root);
    }

    private void postOrderTraversalRecursive(BinaryTreeNode node) {
        if (node != null) {
            postOrderTraversalRecursive(node.left);
            postOrderTraversalRecursive(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);

        System.out.print("In-order traversal: ");
        tree.inOrderTraversal(); // Output: In-order traversal: 3 5 10 7 15
        System.out.println();

        System.out.print("Pre-order traversal: ");
        tree.preOrderTraversal(); // Output: Pre-order traversal: 10 5 3 7 15
        System.out.println();

        System.out.print("Post-order traversal: ");
        tree.postOrderTraversal(); // Output: Post-order traversal: 3 7 5 15 10
        System.out.println();
    }
}


