package trees;

enum Color {
    RED, BLACK
}

class RBNode {
    int key;
    Color color;
    RBNode left, right, parent;

    public RBNode(int key) {
        this.key = key;
        this.color = Color.RED;
    }
}

public class RedBlackTree {
    private RBNode root;
    private RBNode TNULL;

    public RedBlackTree() {
        TNULL = new RBNode(0);
        TNULL.color = Color.BLACK;
        root = TNULL;
    }

    // Method to insert a key into the Red-Black Tree
    public void insert(int key) {
        RBNode newNode = new RBNode(key);
        insertHelper(root, newNode);
        fixRedBlackTree(newNode);
    }

    // Method to fix the Red-Black Tree after insertion
    private void fixRedBlackTree(RBNode node) {
        while (node.parent.color == Color.RED) {
            if (node.parent == node.parent.parent.left) {
                RBNode uncle = node.parent.parent.right;
                if (uncle.color == Color.RED) {
                    // Case 1: Uncle is RED
                    node.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.right) {
                        // Case 2: Uncle is BLACK and node is a right child
                        node = node.parent;
                        leftRotate(node);
                    }
                    // Case 3: Uncle is BLACK and node is a left child
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    rightRotate(node.parent.parent);
                }
            } else {
                RBNode uncle = node.parent.parent.left;
                if (uncle.color == Color.RED) {
                    // Case 1: Uncle is RED
                    node.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                } else {
                    if (node == node.parent.left) {
                        // Case 2: Uncle is BLACK and node is a left child
                        node = node.parent;
                        rightRotate(node);
                    }
                    // Case 3: Uncle is BLACK and node is a right child
                    node.parent.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    leftRotate(node.parent.parent);
                }
            }

            if (node == root) {
                break;
            }
        }

        root.color = Color.BLACK;
    }

    private void leftRotate(RBNode node) {
        RBNode rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != TNULL) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    private void rightRotate(RBNode node) {
        RBNode leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != TNULL) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }

    // Other methods for deletion, search, and in-order traversal can also be added here.
}
