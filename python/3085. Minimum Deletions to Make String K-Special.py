class Solution:
    def minimumDeletions(self, word: str, k: int) -> int:
        freq = [0] * 26
        for i in range(0, len(word)):
            freq[ord(word[i])-ord('a')] += 1
        f = []
        for i in freq:
            if i != 0:
                f.append(i)
        f.sort()
        return self.find(f, 0, len(f)-1, k)
    def find(self, f, left, right, k):
        if left >= right:
            return 0
        if f[right] - f[left] <= k:
            return 0
        return min(f[left] + self.find(f, left+1, right, k), f[right] - f[left] - k + self.find(f, left, right-1, k))



