class Solution:
    def countTriplets(self, arr: List[int]) -> int:
        answer = 0
        for i in range(0, len(arr)):
            xor == ar[i]
            for j in range(i+1, len(arr)):
                xor ^= arr[j]
                if xor == 0: answer += j-i
        return answer