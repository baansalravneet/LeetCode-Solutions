# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        answer = 0
        def dfs(root, sum):
            nonlocal answer
            if not root:
                return
            sum = sum*10 + root.val
            if not root.left and not root.right:
                answer += sum
                return
            dfs(root.left, sum)
            dfs(root.right, sum)
        dfs(root, 0)
        return answer