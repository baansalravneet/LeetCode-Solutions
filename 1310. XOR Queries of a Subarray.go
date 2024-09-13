func xorQueries(arr []int, queries [][]int) []int {
	answer, xorpre := []int{}, []int{0}
	for i := 0; i < len(arr); i++ {
		xorpre = append(xorpre, xorpre[i]^arr[i])
	}
	for _, q := range queries {
		answer = append(answer, xorpre[q[1]+1]^xorpre[q[0]])
	}
	return answer
}