func maximumLength(nums []int) int {
	answer := 2
	for i := 0; i < 2; i++ {
		freq := make([]int, 2)
		count := 0
		for _, v := range nums {
			v %= 2
			freq[v] = freq[(i-v+2)%2] + 1
			count = max(count, freq[v])
		}
		answer = max(answer, count)
	}
	return answer
}