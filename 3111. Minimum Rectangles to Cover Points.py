class Solution:
    def minRectanglesToCoverPoints(self, points: List[List[int]], w: int) -> int:
        points.sort(key=lambda x: x[0])
        previous = -1
        answer = 0
        for point in points:
            if point[0] > previous:
                answer += 1
                previous = point[0] + w
        return answer
