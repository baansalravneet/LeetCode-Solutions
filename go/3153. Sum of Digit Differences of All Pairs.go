func sumDigitDifferences(nums []int) int64 {
	freq := [9][10]int{}
	for _, n := range nums {
		for i := 1; i < 1000000000; i *= 10 {
			digit := (n / i) % 10
			position := findPosition(i)
			freq[position][digit] += 1
		}
	}
	var answer int64
	for pos := 0; pos < 9; pos++ {
		for i := 0; i < 10; i++ {
			for j := i + 1; j < 10; j++ {
				answer += int64(freq[pos][i] * freq[pos][j])
			}
		}
	}
	return answer
}
func findPosition(i int) int {
	if i == 1 {
		return 0
	}
	if i == 10 {
		return 1
	}
	if i == 100 {
		return 2
	}
	if i == 1000 {
		return 3
	}
	if i == 10000 {
		return 4
	}
	if i == 100000 {
		return 5
	}
	if i == 1000000 {
		return 6
	}
	if i == 10000000 {
		return 7
	}
	if i == 100000000 {
		return 8
	}
	return 9
}