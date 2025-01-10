class Solution:
    def minimumDiameterAfterMerge(self, edges1: List[List[int]], edges2: List[List[int]]) -> int:
        n, m = len(edges1)+1, len(edges2)+1
        tree1, degrees1 = self.get_tree(edges1, n)
        tree2, degrees2 = self.get_tree(edges2, m)
        d1 = self.diameter(tree1, degrees1, n)
        d2 = self.diameter(tree2, degrees2, m)
        return max(d1, d2, (d1+1)//2 + (d2+1)//2 + 1)

    def diameter(self, tree: Dict[int, List[int]], degrees: List[int], n: int) -> int:
        far_point, _ = self.find_far(tree, 0, -1)
        _, distance = self.find_far(tree, far_point)
        return distance

    def find_far(self, tree: Dict[int, List[int]], node, parent: int) -> Tuple[int, int]:
        answer = 0
        far_node = -1
        for next_node in tree[node]:
            if next_node == parent: continue
            this_far_node, distance = self.find_far(tree, next_node, node)
            if distance > answer:
                answer = distance
                far_node = this_far_node
        return far_node, answer

    def get_tree(self, edges: List[List[int]], n: int) -> Tuple[Dict[int, List[int]], List[int]]:
        tree = defaultdict(list)
        degrees = [0]*n
        for u, v in edges:
            tree[u].append(v)
            tree[v].append(u)
            degrees[u] += 1
            degrees[v] += 1
        return tree, degrees
