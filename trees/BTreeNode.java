package trees;

public class BTreeNode {
    int[] keys;
    BTreeNode[] children;
    int numKeys;
    boolean leaf;

    public BTreeNode(int t) {
        keys = new int[2 * t - 1];
        children = new BTreeNode[2 * t];
        numKeys = 0;
        leaf = true;
    }
}