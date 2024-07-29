func numTeams(rating []int) int {
	st := &segmentTree{1, 100000, 0, nil, nil}
	leftSmaller := []int{}
	leftLarger := []int{}
	rightSmaller := []int{}
	rightLarger := []int{}
	for i := 0; i < len(rating); i++ {
		leftSmaller = append(leftSmaller, st.findSmaller(rating[i]))
		leftLarger = append(leftLarger, st.findLarger(rating[i]))
		st.add(rating[i])
	}
	st = &segmentTree{1, 100000, 0, nil, nil}
	for i := len(rating)-1; i >= 0; i-- {
		rightSmaller = append(rightSmaller, st.findSmaller(rating[i]))
		rightLarger = append(rightLarger, st.findLarger(rating[i]))
        st.add(rating[i])
	}
	for i := 0; i < len(rating)/2; i++ {
		rightSmaller[i], rightSmaller[len(rating)-1-i] = rightSmaller[len(rating)-1-i], rightSmaller[i]
		rightLarger[i], rightLarger[len(rating)-1-i] = rightLarger[len(rating)-1-i], rightLarger[i]
	}
	answer := 0
	for i := 1; i < len(rating)-1; i++ {
		answer += leftSmaller[i] * rightLarger[i]
		answer += leftLarger[i] * rightSmaller[i]
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

func (s *segmentTree) findSmaller(x int) int {
	if s.max < x {
		return s.count
	}
	mid := (s.min + s.max)/2
	if mid+1 >= x {
		if s.left == nil { return 0 }
		return s.left.findSmaller(x)
	} else {
		answer := 0
		if s.left != nil { answer += s.left.findSmaller(x) }
		if s.right != nil { answer += s.right.findSmaller(x) }
		return answer
	}
}

func (s *segmentTree) findLarger(x int) int {
	if s.min > x {
		return s.count
	}
	mid := (s.min + s.max)/2
	if mid < x {
		if s.right == nil { return 0 }
		return s.right.findLarger(x)
	} else {
		answer := 0
		if s.left != nil { answer += s.left.findLarger(x) }
		if s.right != nil { answer += s.right.findLarger(x) }
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