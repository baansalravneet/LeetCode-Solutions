class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        total = 0
        for i in nums:
            total ^= i
        set = 0
        while set < 32:
            if total & (1 << set) > 0:
                break
            set += 1
        answer1 = 0
        answer2 = 0
        for i in nums:
            if i & (1 << set) > 0:
                answer1 ^= i
            else:
                answer2 ^= i
        return [answer1, answer2]
