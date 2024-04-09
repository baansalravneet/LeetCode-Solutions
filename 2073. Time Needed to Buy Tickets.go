func timeRequiredToBuy(tickets []int, k int) int {
	answer := 0
	for i, tix := range tickets {
		if i <= k {
			answer += min(tix, tickets[k])
		} else {
			answer += min(tix, tickets[k]-1)
		}
	}
	return answer
}