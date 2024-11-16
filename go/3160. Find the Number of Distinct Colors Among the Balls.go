func queryResults(limit int, queries [][]int) []int {
	colourCount := make(map[int]int)
	ballColour := make(map[int]int)
	answer := make([]int, len(queries), len(queries))
	for i, q := range queries {
		ball, colour := q[0], q[1]
		if _, ok := ballColour[ball]; !ok {
			colourCount[colour] += 1
		} else {
			previousColour := ballColour[ball]
			if colourCount[previousColour] == 1 {
				delete(colourCount, previousColour)
			} else {
				colourCount[previousColour] -= 1
			}
			colourCount[colour] += 1
		}
		ballColour[ball] = colour
		answer[i] = len(colourCount)
	}
	return answer
}