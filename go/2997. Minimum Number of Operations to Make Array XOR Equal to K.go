func minOperations(nums []int, k int) int {
	answer := 0
	for i := 0; i < 32; i++ {
		count := 0
		for _, v := range nums {
			if (v & (1 << i)) > 0 {
				count += 1
			}
		}
		if (k&(1<<i) > 0) != (count%2 > 0) {
			answer += 1
		}
	}
	return answer
}