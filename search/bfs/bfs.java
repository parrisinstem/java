package search.bfs;

import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
    String value;
    TreeNode[] children;

    TreeNode(String value) {
        this.value = value;
        this.children = new TreeNode[0];
    }

    @Override
    public String toString() {
        Deque<Object[]> stack = new ArrayDeque<>();
        stack.push(new Object[]{this, 0});
        StringBuilder levelStr = new StringBuilder("\n");

        while (!stack.isEmpty()) {
            Object[] pair = stack.pop();
            TreeNode node = (TreeNode) pair[0];
            int level = (int) pair[1];

            // Indentation based on the level of the node
            if (level > 0) {
                levelStr.append("| ".repeat(level - 1)).append("|-");
            }

            levelStr.append(node.value).append("\n");
            level++;

            // Push children to the stack in reverse order for correct ordering
            for (int i = node.children.length - 1; i >= 0; i--) {
                stack.push(new Object[]{node.children[i], level});
            }
        }

        return levelStr.toString();
    }
}

public class bfs {
    public static TreeNode[] bfs(TreeNode rootNode, String goalValue) {
        Deque<TreeNode[]> pathQueue = new ArrayDeque<>();

        // Initialize with the root node as the starting path
        pathQueue.addFirst(new TreeNode[]{rootNode});

        while (!pathQueue.isEmpty()) {
            TreeNode[] currentPath = pathQueue.removeLast();
            TreeNode currentNode = currentPath[currentPath.length - 1];

            System.out.println("Searching node with value: " + currentNode.value);

            // Check if the goal node is found
            if (currentNode.value.equals(goalValue)) {
                return currentPath;
            }

            // Enqueue new paths by adding children to the current path
            for (TreeNode child : currentNode.children) {
                TreeNode[] newPath = new TreeNode[currentPath.length + 1];
                System.arraycopy(currentPath, 0, newPath, 0, currentPath.length);
                newPath[currentPath.length] = child;
                pathQueue.addFirst(newPath);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        // Create the tree nodes
        TreeNode sampleRootNode = new TreeNode("Home");
        TreeNode docs = new TreeNode("Documents");
        TreeNode photos = new TreeNode("Photos");
        TreeNode myWish = new TreeNode("WishList.txt");
        TreeNode myTodo = new TreeNode("TodoList.txt");
        TreeNode myCat = new TreeNode("Fluffy.jpg");
        TreeNode myDog = new TreeNode("Spot.jpg");

        // Build the tree structure
        sampleRootNode.children = new TreeNode[]{docs, photos};
        docs.children = new TreeNode[]{myWish, myTodo};
        photos.children = new TreeNode[]{myCat, myDog};

        // Print the tree structure
        System.out.println(sampleRootNode);

        // Perform breadth-first search
        TreeNode[] goalPath = bfs(sampleRootNode, "Fluffy.jpg");

        // Check if a path to the goal node is found
        if (goalPath == null) {
            System.out.println("No path found");
        } else {
            System.out.println("Path found");

            // Print the nodes in the path
            for (TreeNode node : goalPath) {
                System.out.println(node.value);
            }
        }
    }
}
