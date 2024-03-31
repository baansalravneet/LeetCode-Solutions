func sumOfTheDigitsOfHarshadNumber(x int) int {
	getSum := func(x int) int {
		sum := 0
		for x > 0 {
			sum += x % 10
			x /= 10
		}
		return sum
	}
	sum := getSum(x)
	if x%sum == 0 {
		return sum
	}
	return -1
}