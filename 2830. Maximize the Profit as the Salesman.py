class Solution:
    def maximizeTheProfit(self, n: int, offers: List[List[int]]) -> int:
        offers.sort(key=lambda x: x[0])
        @cache
        def helper(i):
            if i == len(offers):
                return 0
            answer1 = helper(i+1)
            answer2 = offers[i][2] + helper(getNext(i+1, len(offers)-1, offers[i][1]))
            return max(answer1, answer2)
        def getNext(left, right, end):
            answer = len(offers)
            while left <= right:
                mid = (left+right)//2
                if offers[mid][0] > end:
                    answer = mid
                    right = mid-1
                else:
                    left = mid+1
            return answer
        return helper(0)
