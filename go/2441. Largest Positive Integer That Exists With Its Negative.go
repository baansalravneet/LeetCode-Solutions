func findMaxK(nums []int) int {
	freq := make([]int, 1001)
	answer := -1
	for _, num := range nums {
		if num < 0 {
			freq[-num]++
		}
	}
	for _, num := range nums {
		if num > 0 && freq[num] > 0 && answer < num {
			answer = num
		}
	}
	return answer
}