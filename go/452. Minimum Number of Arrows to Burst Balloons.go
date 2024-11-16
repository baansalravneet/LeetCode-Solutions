func findMinArrowShots(points [][]int) int {
	sort.Slice(points, func(i, j int) bool {
		return points[i][0] < points[j][0]
	})
	count := 0
	for i := 0; i < len(points); {
		count++
		cur := points[i][1]
		for i < len(points) && points[i][0] <= cur {
			cur = min(cur, points[i][1])
			i++
		}
	}
	return count
}