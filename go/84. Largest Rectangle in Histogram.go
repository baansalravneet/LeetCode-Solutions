func largestRectangleArea(heights []int) int {
    stack := NewStack()
	answer := 0
	i := 0
	for ; i < len(heights); i++ {
		for !stack.Empty() && heights[i] <= heights[stack.Top()] {
			height := heights[stack.Pop()]
			if stack.Empty() {
				answer = max(answer, i * height)
			} else {
				answer = max(answer, height * (i - stack.Top() - 1))
			}
		}
		stack.Push(i)
	}
	for !stack.Empty() {
		height := heights[stack.Pop()]
		if stack.Empty() {
			answer = max(answer, i * height)
		} else {
			answer = max(answer, height * (i - stack.Top() - 1))
		}
	}
	return answer
}

type Stack struct {
	data []int
}

func NewStack() *Stack {
	return &Stack{
		data: []int{},
	}
}

func (s *Stack) Push(x int) {
	s.data = append(s.data, x)
}

func (s *Stack) Pop() int {
	if len(s.data) == 0 {
		return -1
	}
	x := s.data[len(s.data)-1]
	s.data = s.data[:len(s.data)-1]
	return x
}

func (s *Stack) Top() int {
	if len(s.data) == 0 {
		return -1
	}
	return s.data[len(s.data)-1]
}

func (s *Stack) Empty() bool {
	return len(s.data) == 0
}