class Solution:
    def numberOfPairs(self, nums1: List[int], nums2: List[int], k: int) -> int:
        freq = {}
        for i in nums2:
            if i*k not in freq:
                freq[i*k] = 0
            freq[i*k] += 1
        answer = 0
        freq2 = {}
        for i in nums1:
            if i not in freq2:
                freq2[i] = 0
            freq2[i] += 1
        for num in freq2:
            i = 1
            while i*i < num:
                if num % i == 0:
                    answer += freq2[num] * freq[i] if i in freq else 0
                    answer += freq2[num] * freq[num//i] if num//i in freq else 0
                i += 1
            if i*i == num:
                answer += freq2[num] * freq[i] if i in freq else 0
        return answer
