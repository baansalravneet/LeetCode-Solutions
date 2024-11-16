func averageWaitingTime(customers [][]int) float64 {
	totalWait, currentTime := 0, 0
	for _, c := range customers {
		arrival, time := c[0], c[1]
		if arrival < currentTime {
			totalWait += currentTime - arrival
		}
		totalWait += time
		currentTime = max(currentTime, arrival) + time
	}
	return float64(totalWait) / float64(len(customers))
}