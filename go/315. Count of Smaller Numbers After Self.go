func countSmaller(nums []int) []int {
    st := &segmentTree{0, 20000, 0, nil, nil}
    answer := []int{}
    for i := len(nums)-1; i >= 0; i-- {
        answer = append(answer, st.find(nums[i]+10000))
        st.add(nums[i]+10000)
    }
    for i := 0; i < len(answer)/2; i++ {
        answer[i], answer[len(answer)-1-i] = answer[len(answer)-1-i], answer[i]
    }
    return answer
}

type segmentTree struct {
	min int
	max int
	count int
	left *segmentTree
	right *segmentTree
}

func (s *segmentTree) find(x int) int {
	if s.max < x {
		return s.count
	}
	mid := (s.min + s.max)/2
	if mid+1 >= x {
		if s.left == nil { return 0 }
		return s.left.find(x)
	} else {
		answer := 0
		if s.left != nil { answer += s.left.find(x) }
		if s.right != nil { answer += s.right.find(x) }
		return answer
	}
}

func (s *segmentTree) add(x int) {
	if s.min > x || s.max < x { return }
	s.count++
	if s.max <= s.min { return }
	mid := (s.min + s.max) / 2
	if x <= mid {
		if s.left == nil { s.left = &segmentTree{s.min, mid, 0, nil, nil} }
		s.left.add(x)
	} else {
		if s.right == nil { s.right = &segmentTree{mid+1, s.max, 0, nil, nil} }
		s.right.add(x)
	}
}