class Solution:
    def sumOfEncryptedInt(self, nums: List[int]) -> int:
        sum = 0
        for i in nums:
            sum += self.encrypt(i)
        return sum
    def encrypt(self, i):
        max_digit = 0
        copy = i
        while copy > 0:
            max_digit = max(max_digit, copy%10)
            copy //= 10
        answer = 0
        while i > 0:
            answer *= 10
            answer += max_digit
            i //= 10
        return answer