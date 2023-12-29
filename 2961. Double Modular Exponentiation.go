func getGoodIndices(variables [][]int, target int) []int {
	result := []int{}
	for i, v := range variables {
		a, b, c, m := v[0], v[1], v[2], v[3]
		if getMod(getMod(a, b, 10), c, m) == target {
			result = append(result, i)
		}
	}
	return result
}

func getMod(a, b, c int) int {
	result := 1
	for b > 0 {
		if b%2 == 1 {
			result = (result * a) % c
		}
		a = (a * a) % c
		b /= 2
	}
	return result
}