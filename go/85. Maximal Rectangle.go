func maximalRectangle(matrix [][]byte) int {
    n := len(matrix)
	histograms := make([][]int, len(matrix))
	for i := range histograms {
		histograms[i] = make([]int, len(matrix[0]))
	}
	for j := range matrix[0] {
		histograms[0][j] = int(matrix[0][j] - '0')
	}
	for i := 1; i < n; i++ {
		for j := range matrix[0] {
			if matrix[i][j] == '1' {
				histograms[i][j] = histograms[i-1][j] + 1
			} else {
				histograms[i][j] = 0
			}
		}
	}
	answer := 0
	for _, histogram := range histograms {
		answer = max(answer, find(histogram))
	}
	return answer
}

func find(histogram []int) int {
	stack := NewStack()
	answer := 0
	i := 0
	for ; i < len(histogram); i++ {
		for !stack.Empty() && histogram[i] <= histogram[stack.Top()] {
			height := histogram[stack.Pop()]
			if stack.Empty() {
				answer = max(answer, height * i)
			} else {
				answer = max(answer, height * (i - stack.Top() - 1))
			}
		}
        stack.Push(i)
	}
	for !stack.Empty() {
		height := histogram[stack.Pop()]
		if stack.Empty() {
			answer = max(answer, height * i)
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
	return &Stack{data: make([]int, 0)}
}

func (s *Stack) Push(x int) {
	s.data = append(s.data, x)
}

func (s *Stack) Pop() int {
	x := s.data[len(s.data)-1]
	s.data = s.data[:len(s.data)-1]
	return x
}

func (s *Stack) Top() int {
	return s.data[len(s.data)-1]
}

func (s *Stack) Empty() bool {
	return len(s.data) == 0
}


