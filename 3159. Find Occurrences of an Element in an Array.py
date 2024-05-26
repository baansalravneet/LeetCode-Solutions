class Solution:
    def occurrencesOfElement(self, nums: List[int], queries: List[int], x: int) -> List[int]:
        answer = [-1]*len(queries)
        positions = []
        for i in range(len(nums)):
            if nums[i] == x:
                positions.append(i)
        for i in range(len(queries)):
            if queries[i] <= len(positions):
                answer[i] = positions[queries[i]-1]
        return answer
