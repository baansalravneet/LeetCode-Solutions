func mincostToHireWorkers(quality []int, wage []int, k int) float64 {
	n := len(quality)
	workers := make([]Worker, n)
	for i := 0; i < n; i++ {
		workers[i] = Worker{quality[i], wage[i]}
	}
	sort.Slice(workers, func(i, j int) bool {
		return workers[i].ratio() < workers[j].ratio()
	})
	answer := math.MaxFloat64
	currentTotal := 0
	var maxHeap IntHeap
	for _, worker := range workers {
		heap.Push(&maxHeap, worker.quality)
		currentTotal += worker.quality
		if len(maxHeap) > k {
			currentTotal -= heap.Pop(&maxHeap).(int)
		}
		if len(maxHeap) == k {
			answer = math.Min(answer, float64(currentTotal)*worker.ratio())
		}
	}
	return answer
}

type IntHeap []int

func (h IntHeap) Len() int            { return len(h) }
func (h IntHeap) Less(i, j int) bool  { return h[i] > h[j] }
func (h IntHeap) Swap(i, j int)       { h[i], h[j] = h[j], h[i] }
func (h *IntHeap) Push(x interface{}) { *h = append(*h, x.(int)) }
func (h *IntHeap) Pop() interface{} {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[:n-1]
	return x
}

type Worker struct {
	quality int
	wage    int
}

func (w Worker) ratio() float64 {
	return float64(w.wage) / float64(w.quality)
}

