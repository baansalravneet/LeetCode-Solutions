func countTriplets(arr []int) int {
	answer := 0
	for i := 0; i < len(arr); i++ {
		xor := arr[i]
		for j := i + 1; j < len(arr); j++ {
			xor ^= arr[j]
			if xor == 0 {
				answer += j - i
			}
		}
	}
	return answer
}