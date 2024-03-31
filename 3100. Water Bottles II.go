func maxBottlesDrunk(numBottles int, numExchange int) int {
	answer := 0
	empty := 0
	for numBottles > 0 {
		answer += numBottles
		empty += numBottles
		numBottles = 0
		for empty >= numExchange {
			empty -= numExchange
			numBottles += 1
			numExchange += 1
		}
	}
	return answer
}