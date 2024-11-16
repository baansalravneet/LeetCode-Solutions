func maximumHappinessSum(happiness []int, k int) int64 {
	sort.Slice(happiness, func(i, j int) bool {
		return happiness[i] > happiness[j]
	})
	var answer int64
	for i := 0; i < k; i++ {
		if happiness[i] > i {
			answer += int64(happiness[i] - i)
		}
	}
	return answer
}