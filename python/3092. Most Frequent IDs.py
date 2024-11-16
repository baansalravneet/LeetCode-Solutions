class Solution:
    def mostFrequentIDs(self, nums: List[int], freq: List[int]) -> List[int]:
        freq_dict = {}
        pq = []
        heapq.heapify(pq)
        answer = []
        for i in range(len(nums)):
            if nums[i] not in freq_dict:
                freq_dict[nums[i]] = 0
            freq_dict[nums[i]] = freq_dict[nums[i]] + freq[i]
            heapq.heappush(pq, (-freq_dict[nums[i]], nums[i]))
            while len(pq) > 0 and (freq_dict[pq[0][1]] != -pq[0][0] or freq_dict[pq[0][1]] == 0):
                heapq.heappop(pq)
            if len(pq) > 0:
                answer.append(-pq[0][0])
            else:
                answer.append(0)
        return answer
