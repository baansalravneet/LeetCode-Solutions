# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def smallestFromLeaf(self, root: Optional[TreeNode]) -> str:
        answer = str(chr(ord('z') + 1))
        def dfs(node, result):
            nonlocal answer
            if not node:
                return
            result = chr(node.val + ord('a')) + result
            if not node.left and not node.right:
                answer = min(answer, result)
            dfs(node.left, result)
            dfs(node.right, result)
            result = result[1:]
        dfs(root, '')
        return answer