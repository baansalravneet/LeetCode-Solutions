class Solution:
    def maxBottlesDrunk(self, numBottles: int, numExchange: int) -> int:
        answer = 0
        empty = 0
        while numBottles > 0:
            answer += numBottles
            empty += numBottles
            numBottles = 0
            while empty >= numExchange:
                empty -= numExchange
                numBottles += 1
                numExchange += 1
        return answer