package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    private int value;
    private List<TreeNode> children;

    public TreeNode(int value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode childNode) {
        System.out.println("Adding " + childNode.getValue());
        children.add(childNode);
    }

    public void removeChild(TreeNode childNode) {
        System.out.println("Removing " + childNode.getValue() + " from " + this.getValue());
        children.remove(childNode);
    }

    public void traverse() {
        Stack<TreeNode> nodesToVisit = new Stack<>();
        nodesToVisit.push(this);

        while (!nodesToVisit.isEmpty()) {
            TreeNode currentNode = nodesToVisit.pop();
            System.out.println(currentNode.getValue());

            for (TreeNode child : currentNode.getChildren()) {
                nodesToVisit.push(child);
            }
        }
    }

    public int getValue() {
        return value;
    }

    public List<TreeNode> getChildren() {
        return children;
    }
}
