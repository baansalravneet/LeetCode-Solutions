func findRelativeRanks(score []int) []string {
	answer := make([]int, len(score))
	for i := range score {
		answer[i] = i
	}
	sort.Slice(answer, func(i, j int) bool {
		return score[answer[i]] > score[answer[j]]
	})
	result := make([]string, len(score))
	for i := range answer {
		switch i {
		case 0:
			result[answer[i]] = "Gold Medal"
		case 1:
			result[answer[i]] = "Silver Medal"
		case 2:
			result[answer[i]] = "Bronze Medal"
		default:
			result[answer[i]] = strconv.Itoa(i + 1)
		}
	}
	return result
}
