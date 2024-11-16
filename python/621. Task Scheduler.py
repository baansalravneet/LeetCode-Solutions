class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = [0] * 26
        for t in tasks:
            freq[ord(t) - ord('A')] += 1
        freq.sort()
        f_max = freq.pop()
        idle_time = (f_max - 1) * n
        while freq and idle_time > 0:
            idle_time -= min(f_max - 1, freq.pop())
        return idle_time + len(tasks) if idle_time > 0 else len(tasks)
