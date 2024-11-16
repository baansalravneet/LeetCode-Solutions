func unmarkedSumArray(nums []int, queries [][]int) []int64 {
	pq := &priorityQueue{}
	heap.Init(pq)
	markedIndices := make(map[int]bool)
	total := 0
	for i, val := range nums {
		total += val
		heap.Push(pq, [2]int{i, val})
	}
	answer := make([]int64, len(queries))
	for i, q := range queries {
		index := q[0]
		count := q[1]
		if _, ok := markedIndices[index]; !ok {
			total -= nums[index]
			markedIndices[index] = true
		}
		for count > 0 && pq.Len() > 0 {
			current := heap.Pop(pq)
			val := current.([2]int)[1]
			idx := current.([2]int)[0]
			if _, ok := markedIndices[idx]; ok {
				continue
			}
			markedIndices[idx] = true
			total -= val
			count -= 1
		}
		answer[i] = int64(total)
	}
	return answer
}

type priorityQueue [][2]int

func (pq priorityQueue) Len() int {
	return len(pq)
}

func (pq priorityQueue) Less(i, j int) bool {
	a := pq[i]
	b := pq[j]
	if a[1] == b[1] {
		return a[0] < b[0]
	}
	return a[1] < b[1]
}

func (pq priorityQueue) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}

func (pq *priorityQueue) Push(x interface{}) {
	item := x.([2]int)
	*pq = append(*pq, item)
}

func (pq *priorityQueue) Pop() interface{} {
	old := *pq
	n := len(old)
	item := old[n-1]
	*pq = old[0 : n-1]
	return item
}
