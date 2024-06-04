func countDays(days int, meetings [][]int) int {
	sort.Slice(meetings, func(i, j int) bool {
		return meetings[i][0] < meetings[j][0]
	})
	i, end, answer := 0, 0, meetings[0][0]-1
	for i < len(meetings) {
		end = meetings[i][1]
		for i < len(meetings) && meetings[i][0] <= end {
			end = max(end, meetings[i][1])
			i++
		}
		if i < len(meetings) {
			answer += meetings[i][0] - end - 1
		}
	}
	answer += days - end
	return answer
}