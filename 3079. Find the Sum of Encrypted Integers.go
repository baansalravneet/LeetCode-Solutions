func sumOfEncryptedInt(nums []int) int {
	sum := 0
	for _, i := range nums {
		sum += encrypt(i)
	}
	return sum
}
func encrypt(i int) int {
	copy := i
	maxDigit := 0
	for copy > 0 {
		maxDigit = max(maxDigit, copy%10)
		copy /= 10
	}
	answer := 0
	for i > 0 {
		answer *= 10
		answer += maxDigit
		i /= 10
	}
	return answer
}

