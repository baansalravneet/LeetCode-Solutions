class Solution:
    def wordSubsets(self, words1: List[str], words2: List[str]) -> List[str]:
        freq = [[Counter(word).get(chr(i + ord('a')), 0) for i in range(26)] for word in words1]
        req_freq = [max(Counter(word).get(chr(i + ord('a')), 0) for word in words2) for i in range(26)]
        answer = []
        for i, word in enumerate(words1):
            if all(freq[i][j] >= req_freq[j] for j in range(26)):
                answer.append(word)
        return answer

