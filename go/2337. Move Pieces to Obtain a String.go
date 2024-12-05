func canChange(start string, target string) bool {
	n := len(start)
	for i, j := 0, 0; i < n || j < n; i, j = i+1, j+1 {
		for i < n && start[i] == '_' {
			i++
		}
		for j < n && target[j] == '_' {
			j++
		}
		if i == n || j == n {
			return i == n && j == n
		}
		if (start[i] == 'L' && i < j) || (start[i] == 'R' && j < i) {
			return false
		}
	}
	return true
}