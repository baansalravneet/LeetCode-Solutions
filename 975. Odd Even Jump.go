func oddEvenJumps(arr []int) int {
	n := len(arr)
	oddJumps, evenJumps := getJumps(arr)
	goodOddJumps := map[int]bool{
		n - 1: true,
	}
	goodEvenJumps := map[int]bool{
		n - 1: true,
	}
	for i := n - 2; i >= 0; i-- {
		oddJump, evenJump := oddJumps[i], evenJumps[i]
		if _, ok := goodOddJumps[evenJump]; ok && evenJump != -1 {
			goodEvenJumps[i] = true
		}
		if _, ok := goodEvenJumps[oddJump]; ok && oddJump != -1 {
			goodOddJumps[i] = true
		}
	}
	return len(goodOddJumps)
}

func getJumps(arr []int) ([]int, []int) {
	index1, index2 := make([]int, len(arr)), make([]int, len(arr))
	for i := 0; i < len(arr); i++ {
		index1[i] = i
		index2[i] = i
	}
	sort.Slice(index1, func(i, j int) bool {
		if arr[index1[i]] == arr[index1[j]] {
			return index1[i] < index1[j]
		}
		return arr[index1[i]] < arr[index1[j]]
	})
	sort.Slice(index2, func(i, j int) bool {
		if arr[index2[i]] == arr[index2[j]] {
			return index2[i] < index2[j]
		}
		return arr[index2[i]] > arr[index2[j]]
	})
	return nextGreater(index1), nextGreater(index2)
}

func nextGreater(arr []int) []int {
	n := len(arr)
	result := make([]int, n)
	for i := range result {
		result[i] = -1
	}
	stack := newStack(n)
	for i := n - 1; i >= 0; i-- {
		for !stack.empty() && stack.peek() < arr[i] {
			stack.pop()
		}
		if !stack.empty() {
			result[arr[i]] = stack.peek()
		}
		stack.push(arr[i])
	}
	return result
}

type stack struct {
	data  []int
	index int
}

func newStack(n int) *stack {
	return &stack{make([]int, n), -1}
}

func (s *stack) push(i int) {
	s.index++
	s.data[s.index] = i
}

func (s *stack) peek() int {
	return s.data[s.index]
}

func (s *stack) pop() int {
	val := s.data[s.index]
	s.index--
	return val
}

func (s *stack) empty() bool {
	return s.index == -1
}