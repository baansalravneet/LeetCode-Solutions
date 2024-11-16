class Solution:
    def wordBreak(self, s: str, word_dict: List[str]) -> List[str]:
        trie = Trie(False)
        for word in word_dict:
            trie.add(word)
        result = []
        self.find(s, trie, result, [], 0)
        return result
    def find(self, s, trie, result, current, index):
        if index == len(s):
            result.append(' '.join(current))
            return
        for i in range(index, len(s)):
            if trie.search(s[index:i+1]):
                current.append(s[index:i+1])
                self.find(s, trie, result, current, i+1)
                current.pop()

class Trie:
    def __init__(self, is_word):
        self.children = [None] * 26
        self.is_word = is_word

    def add(self, word):
        current = self
        for c in word:
            index = ord(c) - ord('a')
            if not current.children[index]:
                current.children[index] = Trie(False)
            current = current.children[index]
        current.is_word = True
    
    def search(self, word):
        current = self
        for c in word:
            index = ord(c) - ord('a')
            if not current.children[index]:
                return False
            current = current.children[index]
        return current.is_word
        