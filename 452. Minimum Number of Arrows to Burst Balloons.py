class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort(key=lambda x: x[0])
        count = 0
        for i in range(len(points)):
            if i == 0:
                count += 1
                end = points[i][1]
            else:
                if points[i][0] <= end:
                    end = min(end, points[i][1])
                else:
                    count += 1
                    end = points[i][1]
        return count