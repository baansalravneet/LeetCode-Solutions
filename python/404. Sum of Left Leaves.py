# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumOfLeftLeaves(self, root: Optional[TreeNode]) -> int:
        return self.helper(root, False)
    def helper(self, root, left):
        if not root:
            return 0
        if not root.left and not root.right:
            if left:
                return root.val
            else:
                return 0
        return self.helper(root.left, True) + self.helper(root.right, False)
