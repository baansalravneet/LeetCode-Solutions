func mostFrequentIDs(nums []int, freq []int) []int64 {
	n := len(nums)
	pq := make(Pq, 0)
	answer := make([]int64, 0)
	count := make(map[int]int)
	for i := 0; i < n; i++ {
		count[nums[i]] = count[nums[i]] + freq[i]
		heap.Push(&pq, NewEle(nums[i], count[nums[i]]))
		for len(pq) > 0 && (count[pq[0].id] != pq[0].count || count[pq[0].id] == 0) {
			heap.Pop(&pq)
		}
		if len(pq) == 0 {
			answer = append(answer, 0)
		} else {
			answer = append(answer, int64(pq[0].count))
		}
	}
	return answer
}

type Pq []Ele

func (pq Pq) Len() int {
	return len(pq)
}
func (pq Pq) Less(i, j int) bool {
	return pq[i].count > pq[j].count
}
func (pq Pq) Swap(i, j int) {
	pq[i], pq[j] = pq[j], pq[i]
}
func (pq *Pq) Push(x interface{}) {
	*pq = append(*pq, x.(Ele))
}
func (pq *Pq) Pop() interface{} {
	n := len(*pq)
	x := (*pq)[n-1]
	*pq = (*pq)[:n-1]
	return x
}

type Ele struct {
	id    int
	count int
}

func NewEle(id, count int) Ele {
	return Ele{
		id:    id,
		count: count,
	}
}