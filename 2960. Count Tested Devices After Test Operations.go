func countTestedDevices(batteryPercentages []int) int {
	count := 0
	for _, battery := range batteryPercentages {
		if battery - count > 0 {
			count++
		}
	}
	return count
}