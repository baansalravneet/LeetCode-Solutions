class Solution:
    def minimumCost(self, n: int, edges: List[List[int]], query: List[List[int]]) -> List[int]:
        uf = UnionFind(n)
        for (x, y, weight) in edges:
            uf.union(x, y, weight)
        answer = []
        for (x, y) in query:
            if x == y:
                answer.append(0)
            elif uf.find(x) != uf.find(y):
                answer.append(-1)
            else:
                weight = uf.findWeight(x)
                answer.append(0) if weight == (1 << 30) - 1 else answer.append(weight)
        return answer
        
class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.bitwise_and = [(1 << 30) - 1] * n

    def find(self, x):
        if self.parent[x] != x:
            self.parent[x] = self.find(self.parent[x])
        return self.parent[x]
    
    def findWeight(self, x):
        return self.bitwise_and[self.find(x)]

    def union(self, x, y, weight):
        root_x = self.find(x)
        root_y = self.find(y)
        if x < y:
            self.parent[root_y] = root_x
            self.bitwise_and[root_x] &= self.bitwise_and[root_y] & weight
        else:
            self.parent[root_x] = root_y
            self.bitwise_and[root_y] &= self.bitwise_and[root_x] & weight