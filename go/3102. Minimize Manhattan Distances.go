func minimumDistance(points [][]int) int {
    result1 := maxDistancePoints(points, -1)
    result2 := maxDistancePoints(points, result1[0])
    result3 := maxDistancePoints(points, result1[1])
    return min(distance(points, result2[0], result2[1]), distance(points, result3[0], result3[1]))
}
func maxDistancePoints(points [][]int, remove int) []int {
	maxSum, maxDiff, minSum, minDiff := math.MinInt32, math.MinInt32, math.MaxInt32, math.MaxInt32
	maxSumIndex, maxDiffIndex, minSumIndex, minDiffIndex := 0, 0, 0, 0
	for i := range(points) {
		if i == remove {
			continue
		}
		sum := points[i][0] + points[i][1]
		diff := points[i][0] - points[i][1]
		if sum > maxSum {
			maxSum = sum
			maxSumIndex = i
		}
		if sum < minSum {
			minSum = sum
			minSumIndex = i
		}
		if diff > maxDiff {
			maxDiff = diff
			maxDiffIndex = i
		}
		if diff < minDiff {
			minDiff = diff
			minDiffIndex = i
		}
	}
	if maxSum - minSum > maxDiff - minDiff {
		return []int{maxSumIndex, minSumIndex}
	}
	return []int{maxDiffIndex, minDiffIndex}
}
func distance(points [][]int, i, j int) int {
    return abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])
}
func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
