func minimumCost(m int, n int, horizontalCut []int, verticalCut []int) int64 {
	var answer int64
	hc, vc := 1, 1
	sort.Ints(horizontalCut)
	sort.Ints(verticalCut)
	i, j := len(horizontalCut)-1, len(verticalCut)-1
	for i >= 0 || j >= 0 {
		if j >= 0 && (i < 0 || horizontalCut[i] < verticalCut[j]) {
			answer += int64(verticalCut[j] * hc)
			vc++
			j--
		} else {
			answer += int64(horizontalCut[i] * vc)
			hc++
			i--
		}
	}
	return answer
}