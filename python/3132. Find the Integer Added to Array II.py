class Solution:
    def minimumAddedInteger(self, nums1: List[int], nums2: List[int]) -> int:
        answer = float('inf')
        nums1.sort()
        nums2.sort()
        for i in range(len(nums1)):
            for j in range(len(nums1)):
                if i == j:
                    continue
                answer = min(answer, self.check(nums1, nums2, i, j))
        return answer
    def check(self, nums1, nums2, i, j):
        p1, p2, diff = 0, 0, float('inf')
        while p1 < len(nums1) and p2 < len(nums2):
            if p1 == i or p1 == j:
                p1 += 1
                continue
            if diff == float('inf'):
                diff = nums2[p2] - nums1[p1]
            if diff != nums2[p2] - nums1[p1]:
                return float('inf')
            p1 += 1
            p2 += 1
        return diff
