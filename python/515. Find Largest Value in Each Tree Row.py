# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def largestValues(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return []
        q = deque([root])
        answer = []
        while q:
            size = len(q)
            m = float('-inf')
            for _ in range(size):
                current = q.popleft()
                m = max(current.val, m)
                if current.left: q.append(current.left)
                if current.right: q.append(current.right)
            answer.append(m)
        return answer
