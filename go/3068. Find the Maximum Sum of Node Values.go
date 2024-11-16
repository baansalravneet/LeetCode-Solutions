func maximumValueSum(nums []int, k int, edges [][]int) int64 {
	n := len(nums)
	netChange := make([]int, n)
	var sum int64 = 0
	for i := 0; i < n; i++ {
		netChange[i] = (nums[i] ^ k) - nums[i]
		sum += int64(nums[i])
	}
	sort.Ints(netChange)
	for i := n - 1; i >= 0; i -= 2 {
		if i == 0 {
			break
		}
		pairSum := netChange[i] + netChange[i-1]
		if pairSum > 0 {
			sum += int64(pairSum)
		}
	}
	return sum
}