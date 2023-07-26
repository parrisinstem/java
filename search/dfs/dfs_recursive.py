class TreeNode:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def dfs_recursive(root, target):
    if root is None:
        return None
    
    if root.value == target:
        return [root.value]
    
    left_path = dfs_recursive(root.left, target)
    if left_path:
        return [root.value] + left_path
    
    right_path = dfs_recursive(root.right, target)
    if right_path:
        return [root.value] + right_path
    
    return None

# Example Usage:
root = TreeNode('A')
root.left = TreeNode('B')
root.right = TreeNode('C')
root.left.left = TreeNode('D')
root.left.right = TreeNode('E')
root.right.left = TreeNode('F')
root.right.right = TreeNode('G')

target_value = 'F'

path = dfs_recursive(root, target_value)
if path:
    print("Path found:", path)
else:
    print("No path found")
