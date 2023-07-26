package search.dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    private String value; // data
    private List<TreeNode> children; // references to other nodes
    
    public TreeNode(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
    
    public String getValue() {
        return value;
    }
    
    public List<TreeNode> getChildren() {
        return children;
    }
    
    public void addChild(TreeNode childNode) {
        // creates parent-child relationship
        System.out.println("Adding " + childNode.getValue());
        children.add(childNode);
    }
    
    public void removeChild(TreeNode childNode) {
        // removes parent-child relationship
        System.out.println("Removing " + childNode.getValue() + " from " + value);
        children.remove(childNode);
    }
    
    public void traverse() {
        // moves through each node referenced from self downwards
        Deque<TreeNode> nodesToVisit = new LinkedList<>();
        nodesToVisit.push(this);
        
        while (!nodesToVisit.isEmpty()) {
            TreeNode currentNode = nodesToVisit.pop();
            System.out.println(currentNode.getValue());
            nodesToVisit.addAll(currentNode.getChildren());
        }
    }
}

class Main {
    public static void printTree(TreeNode root) {
        Deque<Object[]> stack = new LinkedList<>();
        stack.push(new Object[]{root, 0});
        StringBuilder levelStr = new StringBuilder();
        int prevLevel = 0;
        int level = 0;
        
        while (!stack.isEmpty()) {
            prevLevel = level;
            Object[] nodeLevelPair = stack.pop();
            TreeNode node = (TreeNode) nodeLevelPair[0];
            level = (int) nodeLevelPair[1];
            
            if (level > 0 && !stack.isEmpty() && level <= (int) stack.peek()[1]) {
                levelStr.append("   ".repeat(level - 1)).append("├─");
            } else if (level > 0) {
                levelStr.append("   ".repeat(level - 1)).append("└─");
            }
            
            levelStr.append(node.getValue()).append("\n");
            level++;
            
            for (TreeNode child : node.getChildren()) {
                stack.push(new Object[]{child, level});
            }
        }
        
        System.out.println(levelStr.toString());
    }
    
    public static void printPath(List<TreeNode> path) {
        // If path is null, no path was found
        if (path == null) {
            System.out.println("No paths found!");
        } else {
            // If a path was found, print path
            System.out.println("Path found:");
            for (TreeNode node : path) {
                System.out.println(node.getValue());
            }
        }
    }
    
    public static List<TreeNode> dfs(TreeNode root, String target, List<TreeNode> path) {
        // Append the current node to the path
        path.add(root);
        
        // Check if the current node is the target
        if (root.getValue().equals(target)) {
            return path;
        }
        
        // Recursively search in the children
        for (TreeNode child : root.getChildren()) {
            List<TreeNode> pathFound = dfs(child, target, new ArrayList<>(path));
            
            // If a path is found, return it
            if (pathFound != null) {
                return pathFound;
            }
        }
        
        // Return null if the target is not found in the subtree
        return null;
    }
    
    public static void main(String[] args) {
        TreeNode sampleRootNode = new TreeNode("A");
        TreeNode two = new TreeNode("B");
        TreeNode three = new TreeNode("C");
        sampleRootNode.addChild(three);
        sampleRootNode.addChild(two);
        TreeNode four = new TreeNode("D");
        TreeNode five = new TreeNode("E");
        TreeNode six = new TreeNode("F");
        TreeNode seven = new TreeNode("G");
        two.addChild(five);
        two.addChild(four);
        three.addChild(seven);
        three.addChild(six);
        
        // Print the tree structure
        printTree(sampleRootNode);
        
        String target = "F";
        List<TreeNode> path = dfs(sampleRootNode, target, new ArrayList<>());
        
        // Print the path if found
        printPath(path);
    }
}
