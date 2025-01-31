class Solution:
    def minCost(self, n: int, cuts: List[int]) -> int:
        cuts.sort()
        @cache
        def helper(start, end, start_index, end_index):
            if end_index < start_index or cuts[start_index] >= end or cuts[end_index] <= start:
                return 0
            cost = float('+inf')
            for i in range(start_index, end_index+1):
                cut_cost = helper(start, cuts[i], start_index, i-1)
                cut_cost += helper(cuts[i], end, i+1, end_index)
                cost = min(cost, end - start + cut_cost)
            return cost
        return helper(0, n, 0, len(cuts)-1)
