func maximumEnergy(energy []int, k int) int {
	answer := math.MinInt32
	for i := len(energy) - 1; i > len(energy)-1-k; i-- {
		currentSum := 0
		for j := i; j >= 0; j -= k {
			currentSum += energy[j]
			answer = max(answer, currentSum)
		}
	}
	return answer
}