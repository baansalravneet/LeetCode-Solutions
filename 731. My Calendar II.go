type MyCalendarTwo struct {
	root *segmentTreeNode
}

func Constructor() MyCalendarTwo {
	return MyCalendarTwo{
		root: nil,
	}
}

func (this *MyCalendarTwo) Book(start int, end int) bool {
	if !insertable(start, end, this.root) {
		return false
	}
	this.root = insert(start, end, this.root)
	return true
}

func insert(start, end int, current *segmentTreeNode) *segmentTreeNode {
	if start >= end {
		return current
	}
	if current == nil {
		return newSegmentTreeNode(start, end)
	}
	if start >= current.end {
		current.right = insert(start, end, current.right)
	} else if end <= current.start {
		current.left = insert(start, end, current.left)
	} else {
		current.overlap = true
		a, b := min(current.start, start), max(current.start, start)
		c, d := min(current.end, end), max(current.end, end)
		current.left = insert(a, b, current.left)
		current.right = insert(c, d, current.right)
		current.start, current.end = b, c
	}
	return current
}

func insertable(start, end int, current *segmentTreeNode) bool {
	if start >= end {
		return true
	}
	if current == nil {
		return true
	}
	if start >= current.end {
		return insertable(start, end, current.right)
	}
	if end <= current.start {
		return insertable(start, end, current.left)
	}
	if current.overlap {
		return false
	}
	if start >= current.start && end <= current.end {
		return true
	}
	return insertable(start, end, current.left) && insertable(start, end, current.right)
}

type segmentTreeNode struct {
	start   int
	end     int
	overlap bool
	left    *segmentTreeNode
	right   *segmentTreeNode
}

func newSegmentTreeNode(start, end int) *segmentTreeNode {
	return &segmentTreeNode{
		start: start,
		end:   end,
	}
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Book(start,end);
 */
