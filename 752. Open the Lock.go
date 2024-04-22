func openLock(deadends []string, target string) int {
	visited := make(map[string]bool)
	for _, deadend := range deadends {
		visited[deadend] = true
	}
	if _, ok := visited["0000"]; ok {
		return -1
	}
	if target == "0000" {
		return 0
	}
	answer := 0
	q := []string{"0000"}
	for len(q) > 0 {
		size := len(q)
		for i := 0; i < size; i++ {
			current := q[0]
			q = q[1:]
			if current == target {
				return answer
			}
			if _, ok := visited[current]; ok {
				continue
			}
			visited[current] = true
			for _, next := range getNext(current) {
				if _, ok := visited[next]; !ok {
					q = append(q, next)
				}
			}
		}
		answer += 1
	}
	return -1
}

func getNext(current string) []string {
	next := []string{}
	for i := range current {
		next = append(next, current[:i]+string((int(current[i]-'0'+1)%10)+'0')+current[i+1:])
		next = append(next, current[:i]+string((int(current[i]-'0'+9)%10)+'0')+current[i+1:])
	}
	return next
}