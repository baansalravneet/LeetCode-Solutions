func findMaximizedCapital(k int, w int, profits []int, capital []int) int {
	n := len(profits)
	projects := make([]*Project, n)
	for i := range profits {
		projects[i] = newProject(profits[i], capital[i])
	}
	sort.Slice(projects, func(i, j int) bool {
		return projects[i].capital < projects[j].capital
	})
	profitHeap := &MaxHeap{}
	heap.Init(profitHeap)
	for i := 0; i < n && k > 0; i++ {
		if projects[i].capital <= w {
			heap.Push(profitHeap, projects[i])
			continue
		}
		i -= 1
		if profitHeap.Len() == 0 {
			break
		}
		w += heap.Pop(profitHeap).(*Project).profit
		k -= 1
	}
	for k > 0 && profitHeap.Len() > 0 {
		w += heap.Pop(profitHeap).(*Project).profit
		k -= 1
	}
	return w
}

type MaxHeap []*Project

func (h MaxHeap) Len() int           { return len(h) }
func (h MaxHeap) Less(i, j int) bool { return h[i].profit > h[j].profit }
func (h MaxHeap) Swap(i, j int)      { h[i], h[j] = h[j], h[i] }

func (h *MaxHeap) Push(x any) {
	*h = append(*h, x.(*Project))
}

func (h *MaxHeap) Pop() any {
	old := *h
	n := len(old)
	x := old[n-1]
	*h = old[0 : n-1]
	return x
}

type Project struct {
	capital int
	profit  int
}

func newProject(profit, capital int) *Project {
	return &Project{profit: profit, capital: capital}
}