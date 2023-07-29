package trees;

class AVLNode {
    int key;
    int height;
    AVLNode left, right;

    public AVLNode(int key) {
        this.key = key;
        this.height = 1;
    }
}

public class AVLTree {
    private AVLNode root;

    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private AVLNode insertRecursive(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key);
        }

        if (key < node.key) {
            node.left = insertRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = insertRecursive(node.right, key);
        } else {
            return node; // Duplicate keys are not allowed
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            return rotateRight(node);
        }

        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            return rotateLeft(node);
        }

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private AVLNode deleteRecursive(AVLNode node, int key) {
        if (node == null) {
            return node;
        }

        if (key < node.key) {
            node.left = deleteRecursive(node.left, key);
        } else if (key > node.key) {
            node.right = deleteRecursive(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                AVLNode temp = node.left != null ? node.left : node.right;

                if (temp == null) {
                    node = null;
                } else {
                    node = temp;
                }
            } else {
                AVLNode temp = findMinNode(node.right);
                node.key = temp.key;
                node.right = deleteRecursive(node.right, temp.key);
            }
        }

        if (node == null) {
            return node;
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        int balance = getBalance(node);

        // Left Left Case
        if (balance > 1 && getBalance(node.left) >= 0) {
            return rotateRight(node);
        }

        // Left Right Case
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Right Case
        if (balance < -1 && getBalance(node.right) <= 0) {
            return rotateLeft(node);
        }

        // Right Left Case
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private AVLNode findMinNode(AVLNode node) {
        AVLNode current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(AVLNode node, int key) {
        if (node == null) {
            return false;
        }

        if (key == node.key) {
            return true;
        } else if (key < node.key) {
            return searchRecursive(node.left, key);
        } else {
            return searchRecursive(node.right, key);
        }
    }

    public void inOrderTraversal() {
        inOrderTraversalRecursive(root);
    }

    private void inOrderTraversalRecursive(AVLNode node) {
        if (node != null) {
            inOrderTraversalRecursive(node.left);
            System.out.print(node.key + " ");
            inOrderTraversalRecursive(node.right);
        }
    }

    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        avlTree.insert(10);
        avlTree.insert(5);
        avlTree.insert(15);
        avlTree.insert(3);
        avlTree.insert(7);

        System.out.print("In-order traversal: ");
        avlTree.inOrderTraversal(); // Output: 3 5 7 10 15
        System.out.println();

        avlTree.delete(7);

        System.out.print("In-order traversal after deleting 7: ");
        avlTree.inOrderTraversal(); // Output: 3 5 10 15
        System.out.println();

        System.out.println("Is 15 present in the tree? " + avlTree.search(15));
        System.out.println("Is 7 present in the tree? " + avlTree.search(7)); // Output: false
    }
}
