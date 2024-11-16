# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def addOneRow(self, root: Optional[TreeNode], val: int, depth: int) -> Optional[TreeNode]:
        if depth == 1:
            return TreeNode(val, root, None)
        q = [root]
        while depth > 2:
            size = len(q)
            while size > 0:
                current = q.pop(0)
                if current.left:
                    q.append(current.left)
                if current.right:
                    q.append(current.right)
                size -= 1
            depth -= 1
        for node in q:
            node.left = TreeNode(val, node.left, None)
            node.right = TreeNode(val, None, node.right)
        return root
