func minimumAddedInteger(nums1 []int, nums2 []int) int {
	sort.Ints(nums1)
	sort.Ints(nums2)
	answer := math.MaxInt32
	for i := range nums1 {
		for j := range nums1 {
			if i == j {
				continue
			}
			answer = min(answer, check(nums1, nums2, i, j))
		}
	}
	return answer
}
func check(nums1, nums2 []int, i, j int) int {
	diff, p1, p2 := math.MaxInt32, 0, 0
	for p1 < len(nums1) && p2 < len(nums2) {
		if p1 == i || p1 == j {
			p1 += 1
			continue
		}
		if diff == math.MaxInt32 {
			diff = nums2[p2] - nums1[p1]
		}
		if diff != nums2[p2]-nums1[p1] {
			return math.MaxInt32
		}
		p1 += 1
		p2 += 1
	}
	return diff
}