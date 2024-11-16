class Solution:
    def minOperations(self, k: int) -> int:
        sqrt = int(math.sqrt(k))
        return sqrt - 1 + (k-1)//sqrt
