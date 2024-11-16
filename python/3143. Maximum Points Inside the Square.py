class Solution:
    def maxPointsInsideSquare(self, points: List[List[int]], s: str) -> int:
        p_list = []
        for i in range(len(points)):
            p_list.append(Point(points[i][0], points[i][1], s[i]))
        p_list.sort(key=lambda x: x.distance())
        set_p = set()
        answer = 0
        i = 0
        while i < len(p_list):
            distance = p_list[i].distance()
            subset = set()
            while i < len(p_list) and p_list[i].distance() == distance:
                if p_list[i].tag in set_p or p_list[i].tag in subset:
                    return answer
                subset.add(p_list[i].tag)
                i += 1
            answer = i
            set_p |= subset
        return answer

class Point:
    def __init__(self, x, y, tag):
        self.x = x
        self.y = y
        self.tag = tag
    def distance(self):
        return max(abs(self.x), abs(self.y))
