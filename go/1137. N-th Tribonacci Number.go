func tribonacci(n int) int {
	if n == 0 {
		return 0
	}
	if n == 1 || n == 2 {
		return 1
	}
	a, b, c := 0, 1, 1
	for n >= 3 {
		c, b, a = a+b+c, c, b
		n -= 1
	}
	return c
}