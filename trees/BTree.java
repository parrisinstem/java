package trees;

public class BTree {
    private BTreeNode root;
    private int t; // Minimum degree of the B-tree

    public BTree(int t) {
        this.t = t;
        root = new BTreeNode(t);
    }

    public void insert(int key) {
        if (root.numKeys == 2 * t - 1) {
            BTreeNode newRoot = new BTreeNode(t);
            newRoot.children[0] = root;
            splitChild(newRoot, 0);
            root = newRoot;
        }
        insertNonFull(root, key);
    }

    private void insertNonFull(BTreeNode node, int key) {
        int i = node.numKeys - 1;
        if (node.leaf) {
            while (i >= 0 && key < node.keys[i]) {
                node.keys[i + 1] = node.keys[i];
                i--;
            }
            node.keys[i + 1] = key;
            node.numKeys++;
        } else {
            while (i >= 0 && key < node.keys[i]) {
                i--;
            }
            i++;
            if (node.children[i].numKeys == 2 * t - 1) {
                splitChild(node, i);
                if (key > node.keys[i]) {
                    i++;
                }
            }
            insertNonFull(node.children[i], key);
        }
    }

    private void splitChild(BTreeNode parentNode, int childIndex) {
        BTreeNode childNode = parentNode.children[childIndex];
        BTreeNode newNode = new BTreeNode(t);
        newNode.leaf = childNode.leaf;
        newNode.numKeys = t - 1;

        for (int j = 0; j < t - 1; j++) {
            newNode.keys[j] = childNode.keys[j + t];
        }

        if (!childNode.leaf) {
            for (int j = 0; j < t; j++) {
                newNode.children[j] = childNode.children[j + t];
            }
        }

        childNode.numKeys = t - 1;

        for (int j = parentNode.numKeys; j >= childIndex + 1; j--) {
            parentNode.children[j + 1] = parentNode.children[j];
        }

        parentNode.children[childIndex + 1] = newNode;

        for (int j = parentNode.numKeys - 1; j >= childIndex; j--) {
            parentNode.keys[j + 1] = parentNode.keys[j];
        }

        parentNode.keys[childIndex] = childNode.keys[t - 1];
        parentNode.numKeys++;
    }

    public void print() {
        printRecursive(root, "");
    }

    private void printRecursive(BTreeNode node, String indent) {
        if (node != null) {
            System.out.print(indent);
            for (int i = 0; i < node.numKeys; i++) {
                System.out.print(node.keys[i] + " ");
            }
            System.out.println();

            if (!node.leaf) {
                for (int i = 0; i <= node.numKeys; i++) {
                    printRecursive(node.children[i], indent + "    ");
                }
            }
        }
    }

    public static void main(String[] args) {
        BTree bTree = new BTree(3); // B-tree with minimum degree 3

        bTree.insert(5);
        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(30);
        bTree.insert(40);
        bTree.insert(50);

        System.out.println("B-tree structure:");
        bTree.print();
    }
}
