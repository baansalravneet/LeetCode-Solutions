class Solution:
    def unmarkedSumArray(self, nums: List[int], queries: List[List[int]]) -> List[int]:
        heap = []
        heapq.heapify(heap)
        marked = set()
        total = 0
        for i in range(len(nums)):
            total += nums[i]
            heapq.heappush(heap, (nums[i], i))
        res = []
        for query in queries:
            index, count = query
            if index not in marked:
                total -= nums[index]
                marked.add(index)
            while heap and count > 0:
                current = heapq.heappop(heap)
                if current[1] in marked:
                    continue
                total -= current[0]
                marked.add(current[1])
                count -= 1
            res.append(total)
        return res
