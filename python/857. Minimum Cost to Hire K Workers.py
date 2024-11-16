class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        n = len(wage)
        workers = []
        for i in range(n):
            workers.append(Worker(wage[i], quality[i]))
        workers.sort(key=lambda x: x.ratio())
        answer = float('inf')
        current_total = 0
        qualities = []
        for i in range(n):
            current_total += workers[i].quality
            heapq.heappush(qualities, -workers[i].quality)
            if len(qualities) > k:
                current_total -= -heapq.heappop(qualities)
            if len(qualities) == k:
                answer = min(answer, current_total * workers[i].ratio())
        return answer

class Worker:
    def __init__(self, wage, quality):
        self.wage = wage
        self.quality = quality
    def ratio(self):
        return self.wage / self.quality
    def __str__(self):
        return f'wage: {self.wage}, quality: {self.quality}'
