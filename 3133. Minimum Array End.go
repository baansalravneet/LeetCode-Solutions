func minEnd(n int, x int) int64 {
    var answer int64 = 0
    pointer := 0
	n -= 1
	for x > 0 || n > 0 {
		if x%2 == 1 {
			answer += (1 << pointer)
		} else {
            if n%2 == 1 {
				answer += (1 << pointer)
            }
			n /= 2
		}
		pointer += 1
		x /= 2
	}
	return answer
}