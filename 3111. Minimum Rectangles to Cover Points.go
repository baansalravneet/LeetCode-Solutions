func minRectanglesToCoverPoints(points [][]int, w int) int {
	sort.Slice(points, func(i, j int) bool {
		return points[i][0] < points[j][0]
	})
	answer := 0
	previous := -1
	for _, p := range points {
		if p[0] > previous {
			answer += 1
			previous = p[0] + w
		}
	}
	return answer
}