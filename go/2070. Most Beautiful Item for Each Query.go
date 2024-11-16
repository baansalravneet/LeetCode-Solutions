func maximumBeauty(items [][]int, queries []int) []int {
	sort.Slice(items, func(i, j int) bool {
		return items[i][0] < items[j][0]
	})
	for i := 1; i < len(items); i++ {
		items[i][1] = max(items[i-1][1], items[i][1])
	}
	answer := make([]int, len(queries))
	for i, v := range queries {
		answer[i] = find(items, v)
	}
	return answer
}

func find(items [][]int, price int) int {
	answer := 0
	left, right := 0, len(items)-1
	for (left <= right) {
		mid := (left + right) / 2
		if items[mid][0] > price {
			right = mid - 1
		} else {
			answer = items[mid][1]
			left = mid + 1
		}
	}
	return answer
}