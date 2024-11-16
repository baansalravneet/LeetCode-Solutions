class Solution:
    def minimumOperationsToMakeKPeriodic(self, word: str, k: int) -> int:
        max_freq = 0
        freq = {}
        for i in range(0, len(word), k):
            sub = word[i:i+k]
            if sub not in freq:
                freq[sub] = 0
            freq[sub] += 1
            max_freq = max(max_freq, freq[sub])
        return len(word)//k - max_freq
