class Solution:
    def minimumDistance(self, points: List[List[int]]) -> int:
        result1 = self.max_distance_points(points, -1)
        result2 = self.max_distance_points(points, result1[0])
        result3 = self.max_distance_points(points, result1[1])
        return min(self.distance(points, result2[0], result2[1]), self.distance(points, result3[0], result3[1]))

    def max_distance_points(self, points, remove):
        max_sum_index, min_sum_index, max_diff_index, min_diff_index = 0, 0, 0, 0
        max_sum, max_diff, min_sum, min_diff = -inf, -inf, inf, inf
        for i in range(len(points)):
            if i != remove:
                sum = points[i][0]+points[i][1]
                diff = points[i][0]-points[i][1]
                if max_sum < sum:
                    max_sum = sum
                    max_sum_index = i
                if max_diff < diff:
                    max_diff = diff
                    max_diff_index = i
                if min_sum > sum:
                    min_sum = sum
                    min_sum_index = i
                if min_diff > diff:
                    min_diff = diff
                    min_diff_index = i
        return (max_sum_index, min_sum_index) if max_sum-min_sum > max_diff-min_diff else (max_diff_index, min_diff_index)
        
    def distance(self, points, i, j):
        return abs(points[i][0]-points[j][0]) + abs(points[i][1]-points[j][1])

