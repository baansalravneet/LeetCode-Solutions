func intersection(nums1 []int, nums2 []int) []int {
	freq1 := [1001]bool{}
	freq2 := [1001]bool{}
	for _, i := range nums1 {
		freq1[i] = true
	}
	for _, i := range nums2 {
		freq2[i] = true
	}
	answer := []int{}
	for i := 0; i < 1001; i++ {
		if freq1[i] && freq2[i] {
			answer = append(answer, i)
		}
	}
	return answer
}