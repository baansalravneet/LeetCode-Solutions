class Solution:
    def stringIndices(self, wordsContainer: List[str], wordsQuery: List[str]) -> List[int]:
        db = Trie()
        for i, word in enumerate(wordsContainer):
            db.add(word, i)
        return [db.find(word) for word in wordsQuery]

class Trie:
    def __init__(self):
        self.children = {}
        self.index = +inf
        self.length = +inf
        
    def add(self, word, index):
        current = self
        if current.length > len(word):
            current.length = len(word)
            current.index = index
        for i in range(len(word)):
            c = word[len(word) - i - 1]
            if c not in current.children:
                current.children[c] = Trie()
            current = current.children[c]
            if current.length > len(word):
                current.length = len(word)
                current.index = index
        
    def find(self, word):
        current = self
        for i in range(len(word)):
            c = word[len(word) - i - 1]
            if c not in current.children:
                break
            current = current.children[c]
        return current.index
