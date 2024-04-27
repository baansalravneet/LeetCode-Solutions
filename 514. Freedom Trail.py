class Solution:
    def findRotateSteps(self, ring: str, key: str) -> int:
        index = {}
        for i, c in enumerate(ring):
            if c not in index:
                index[c] = []
            index[c].append(i)
        @cache
        def helper(i, currIndex):
            nonlocal ring, key, index
            if i == len(key):
                return 0
            answer = float('inf')
            for next in index[key[i]]:
                d = abs(next - currIndex)
                distance = min(d, len(ring)-d)+1
                answer = min(answer, distance + helper(i+1, next))
            return answer
        