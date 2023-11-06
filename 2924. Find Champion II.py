class Solution(object):
    def findChampion(self, n, edges):
        in_deg = [0] * n
        for edge in edges:
            in_deg[edge[1]] += 1
        answer, count = -1, 0
        for idx, i in enumerate(in_deg):
            if i == 0:
                answer = idx
                count += 1
        if count == 1:
            return answer
        else:
            return -1
