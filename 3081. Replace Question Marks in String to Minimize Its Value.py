class Solution:
    def minimizeStringValue(self, s: str) -> str:
        freq = [0] * 26
        count = 0
        for c in s:
            if c == '?':
                count += 1
            else:
                freq[ord(c) - ord('a')] += 1
        arr = []
        def find(freq):
            min = 1000000000
            minFreqChar = '?'
            for i in range(26):
                if freq[i] < min:
                    min = freq[i]
                    minFreqChar = chr(i + ord('a'))
            freq[ord(minFreqChar) - ord('a')] += 1
            return minFreqChar
        for i in range(count):
            arr.append(find(freq))
        arr = sorted(arr)
        index = 0
        answer = []
        for c in s:
            if c == '?':
                answer.append(arr[index])
                index += 1
            else:
                answer.append(c)
        return ''.join(answer)
