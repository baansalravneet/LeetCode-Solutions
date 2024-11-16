class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        answer = 0
        for i in range(0, 32):
            count = 0
            for v in nums:
                if (v & (1<<i)) > 0:
                    count += 1
            if ((count%2)>0) != ((k&(1<<i))>0):
                answer += 1
        return answer