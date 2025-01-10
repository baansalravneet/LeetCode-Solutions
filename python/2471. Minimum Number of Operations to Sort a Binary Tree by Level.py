# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minimumOperations(self, root: Optional[TreeNode]) -> int:
        q = deque([root])
        answer = 0
        while q:
            size = len(q)
            level = []
            while size > 0:
                current = q.popleft()
                level.append(current.val)
                if current.left:
                    q.append(current.left)
                if current.right:
                    q.append(current.right)
                size -= 1
            answer += self.get_swaps(level)
        return answer
    def get_swaps(self, original: list) -> int:
        swaps = 0
        target = sorted(original)
        pos = {val: idx for idx, val in enumerate(original)}
        for i in range(len(original)):
            if original[i] != target[i]:
                swaps += 1
                target_position = pos[target[i]]
                pos[original[i]] = target_position
                original[target_position] = original[i]
        return swaps

