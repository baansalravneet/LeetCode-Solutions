class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        deck.sort()
        q = collections.deque()
        for i in range (len(deck)-1, -1, -1):
            if q:
                q.appendleft(q.pop())
            q.appendleft(deck[i])
        return list(q)
