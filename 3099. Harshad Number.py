class Solution:
    def sumOfTheDigitsOfHarshadNumber(self, x: int) -> int:
        def getSum(x):
            sum = 0
            while x > 0:
                sum += x % 10
                x //= 10
            return sum
        sum = getSum(x)
        return sum if x % sum == 0 else -1