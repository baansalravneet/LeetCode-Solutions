class Solution:
    def openLock(self, deadends: List[str], target: str) -> int:
        visited = set(deadends)
        if "0000" in visited:
            return -1
        if target == "0000":
            return 0
        q = ["0000"]
        answer = 0
        while q:
            answer += 1
            print(answer)
            size = len(q)
            for _ in range(size):
                curr = q.pop(0)
                if curr == target:
                    return answer
                if curr in visited:
                    continue
                visited.add(curr)
                for next in self.getNext(curr):
                    if next in visited:
                        continue
                    if next == target:
                        return answer
                    q.append(next)
        return -1
    def getNext(self, curr):
        result = []
        for i in range(4):
            for j in [-1, 1]:
                next = list(curr)
                next[i] = str((int(next[i]) + j) % 10)
                result.append("".join(next))
        return result
