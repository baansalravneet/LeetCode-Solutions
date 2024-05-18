# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def distributeCoins(self, root: Optional[TreeNode]) -> int:
        answer = 0
        def find_answer(root):
            nonlocal answer
            if not root: return 0
            required = find_answer(root.left) + find_answer(root.right) + 1 - root.val
            answer += abs(required)
            return required
        find_answer(root)
        return answer