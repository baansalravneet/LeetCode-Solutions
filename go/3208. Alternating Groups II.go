func numberOfAlternatingGroups(colors []int, k int) int {
	answer := 0
	i := 0
	for i < len(colors) {
		current := colors[i]
        i++
		count := 1
		for i < len(colors) && current == 1-colors[i] {
			count++
			current = colors[i]
            i++
		}
		if count >= k {
			answer += count - k + 1
		}
	}
	return answer + checkStartEnd(colors, k)
}

func checkStartEnd(colors []int, k int) int {
	if colors[0] == colors[len(colors)-1] {
		return 0
	}
	prefix, suffix := 1, 1
	current := colors[0]
	i := 1
	for i < len(colors) && current == 1-colors[i] {
		prefix++
		current = colors[i]
		i++
	}
	i = len(colors)-2
	current = colors[len(colors)-1]
	for i >= 0 && current == 1-colors[i] {
		suffix++
		current = colors[i]
		i--
	}
	if suffix + prefix < k {
		return 0
	}
	return min(suffix+prefix-k+1, k-1, suffix, prefix)
}