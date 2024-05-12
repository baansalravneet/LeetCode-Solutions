class Solution:
    def minimumSubstringsInPartition(self, s: str) -> int:
        @cache
        def helper(index):
            if index == len(s):
                return 0
            ans = len(s)
            freq = defaultdict(lambda: 0)
            for i in range(index, len(s)):
                freq[s[i]] += 1
                if check(freq):
                    ans = min(ans, 1 + helper(i + 1))
            return ans
        def check(freq):
            val = -1
            for f in freq:
                if val == -1:
                    val = freq[f]
                if freq[f] != val:
                    return False
            return True
        return helper(0)