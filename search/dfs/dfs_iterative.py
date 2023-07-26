class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def dfs_iterative(root, target):
    if root is None:
        return None

    stack = [(root, [root.value])]  # Stack to store nodes and their corresponding paths

    while stack:
        node, path = stack.pop()

        if node.value == target:
            return path  # Return the path if target value is found

        if node.right:
            stack.append((node.right, path + [node.right.value]))  # Add right child to stack

        if node.left:
            stack.append((node.left, path + [node.left.value]))  # Add left child to stack

    return None  # Return None if target value is not found

# Example Usage:
root = TreeNode('A')
root.left = TreeNode('B')
root.right = TreeNode('C')
root.left.left = TreeNode('D')
root.left.right = TreeNode('E')
root.right.left = TreeNode('F')
root.right.right = TreeNode('G')

target_value = 'F'

path = dfs_iterative(root, target_value)
if path:
    print("Path found:", path)
else:
    print("No path found")
