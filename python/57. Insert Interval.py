class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        result = []
        inserted = False
        for i in intervals:
            if not inserted and newInterval[0] < i[0]:
                self.checkedAppend(result, newInterval)
                inserted = True
            self.checkedAppend(result, i)
        if not inserted:
            self.checkedAppend(result, newInterval)
        return result
    def checkedAppend(self, result, newInterval):
        if not result:
            result.append(newInterval)
        else:
            lastInterval = result[-1]
            if self.overlapping(lastInterval, newInterval):
                result[-1] = self.merge(lastInterval, newInterval)
            else:
                result.append(newInterval)
    def overlapping(self, a, b):
        return a[1] - a[0] + 1 + b[1] - b[0] + 1 > max(a[1], b[1]) - min(a[0], b[0]) + 1
    def merge(self, a, b):
        return [min(a[0], b[0]), max(a[1], b[1])]


