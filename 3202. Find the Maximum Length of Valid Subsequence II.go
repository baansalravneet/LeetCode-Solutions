func maximumLength(nums []int, k int) int {
	answer := 2
	for i := 0; i < k; i++ {
		freq := make([]int, k)
		count := 0
		for _, v := range nums {
			v %= k
			freq[v] = freq[(i-v+k)%k] + 1
			count = max(count, freq[v])
		}
		answer = max(answer, count)
	}
	return answer
}
