class Solution:
    def findCriticalAndPseudoCriticalEdges(self, n: int, edges: List[List[int]]) -> List[List[int]]:
        indexes = dict()
        for i in range(len(edges)):
            indexes[tuple(edges[i])] = i
        edges.sort(key=lambda x: x[2])
        min_weight = self.build_tree(n, edges, None, None)
        critical = []
        pseudo_critical = []
        for e in edges:
            skip_cost = self.build_tree(n, edges, e, None)
            if skip_cost > min_weight:
                critical.append(indexes[tuple(e)])
            else:
                take_cost = self.build_tree(n, edges, None, e)
                if take_cost == min_weight:
                    pseudo_critical.append(indexes[tuple(e)])
        return [critical, pseudo_critical]

    def build_tree(self, n: int, edges: List[List[int]], skip, pick: List[int]) -> int:
        uf = UnionFind(n)
        cost = 0
        if pick:
            uf.union(pick[0], pick[1])
            cost += pick[2]
        for e in edges:
            if e == skip or e == pick:
                continue
            if uf.union(e[0], e[1]):
                cost += e[2]
        return cost if uf.count == 1 else float('+inf')

class UnionFind:
    def __init__(self, n):
        self.parent = list(range(n))
        self.count = n
    def union(self, a, b: int) -> bool:
        pA, pB = self.find(a), self.find(b)
        if pA == pB:
            return False
        self.parent[pA] = pB
        self.count -= 1
        return True
    def find(self, a: int) -> int:
        if self.parent[a] == a:
            return a
        self.parent[a] = self.find(self.parent[a])
        return self.parent[a]

