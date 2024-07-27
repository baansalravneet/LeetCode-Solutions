func minimumCost(source string, target string, original []byte, changed []byte, cost []int) int64 {
	costs := [26][26]int{}
	for i := range costs {
		for j := range costs[i] {
			costs[i][j] = math.MaxInt32
		}
	}
	for i := range costs {
		costs[i][i] = 0
	}
    for i, c := range cost {
        costs[original[i]-'a'][changed[i]-'a'] = min(c, costs[original[i]-'a'][changed[i]-'a'])
    }
	for k := 0; k < 26; k++ {
		for i := 0; i < 26; i++ {
			if costs[i][k] == math.MaxInt32 { continue }
			for j := 0; j < 26; j++ {
				if costs[k][j] == math.MaxInt32 { continue }
				costs[i][j] = min(costs[i][j], costs[i][k]+costs[k][j])
			}
		}
	}
	var answer int64 = 0
	for i, c := range source {
        if costs[c-'a'][target[i]-'a'] == math.MaxInt32 { return -1 }
		answer += int64(costs[c-'a'][target[i]-'a'])
	}
	return answer
}