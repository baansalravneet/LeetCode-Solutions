func shortestSubarray(nums []int, k int) int {
	n := len(nums)
	prefix := make([]int, n+1)
	for i := 0; i < n; i++ {
		prefix[i+1] = prefix[i] + nums[i]
	}
	monoq := make([]int, 0, n)
	answer := n+1
	for i := 0; i <= n; i++ {
		for len(monoq) > 0 && prefix[i] - prefix[monoq[0]] >= k {
			answer = min(answer, i - monoq[0])
			monoq = monoq[1:]
		}
		for len(monoq) > 0 && prefix[i] <= prefix[monoq[len(monoq)-1]] {
			monoq = monoq[:len(monoq)-1]
		}
		monoq = append(monoq, i)
	}
	if answer <= n {
		return answer
	}
	return -1
}