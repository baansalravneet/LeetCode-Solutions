class Solution:
    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        count = [0] * 26
        for letter in letters:
            count[ord(letter)-ord('a')] += 1
        return self.find(words, count, score, 0)
    def find(self, words, count, score, index):
        if index >= len(words): return 0
        answer = self.find(words, count, score, index+1)
        if self.can_make(words[index], count):
            for letter in words[index]:
                count[ord(letter)-ord('a')] -= 1
            word_score = self.find_score(words[index], score)
            answer = max(answer, word_score + self.find(words, count, score, index+1))
            for letter in words[index]:
                count[ord(letter)-ord('a')] += 1
        return answer
    def can_make(self, word, count):
        word_count = [0] * 26
        for letter in word:
            word_count[ord(letter)-ord('a')] += 1
        for i in range(26):
            if count[i] < word_count[i]: return False
        return True
    def find_score(self, word, score):
        answer = 0
        for letter in word:
            answer += score[ord(letter)-ord('a')]
        return answer
