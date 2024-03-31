func countSubarrays(nums []int, minK int, maxK int) int64 {
	var answer int64
	minI, maxI, badI := -1, -1, -1
	for i, v := range nums {
		if v < minK || v > maxK {
			badI = i
		}
		if v == minK {
			minI = i
		}
		if v == maxK {
			maxI = i
		}
		answer += int64(max(0, min(maxI, minI)-badI))
	}
	return answer
}