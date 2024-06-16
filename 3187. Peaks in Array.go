func countOfPeaks(nums []int, queries [][]int) []int {
    st := newSegmentTree(len(nums))
    for i := range nums {
        if checkPeak(nums, i) {
            st.update(i, 1, 1, 0, len(nums)-1)
        }
    }
    result := []int{}
    for _, q := range queries {
        if q[0] == 1 {
            result = append(result, st.query(q[1]+1, q[2]-1, 0, len(nums)-1, 1))
        } else {
            index := q[1]
            value := q[2]
            nums[index] = value
            for i := index-1; i <= index+1; i++ {
                if checkPeak(nums, i) {
                    st.update(i, 1, 1, 0, len(nums)-1)
                } else {
                    st.update(i, 0, 1, 0, len(nums)-1)
                }
            }
        }
    }
    return result
}

func checkPeak(nums []int, i int) bool {
    return i > 0 && i < len(nums)-1 && nums[i] > nums[i-1] && nums[i] > nums[i+1]
}

type segmentTree struct {
    tree []int
}

func newSegmentTree(n int) *segmentTree {
    return &segmentTree { tree: make([]int, 4*n) }
}

func (s *segmentTree) query(queryLeft, queryRight, left, right, treeNode int) int {
    if left > right { return 0 }
    if queryRight < left || queryLeft > right { return 0 }
    if queryLeft <= left && queryRight >= right { return s.tree[treeNode] }
    mid := (left+right)/2
    return s.query(queryLeft, queryRight, left, mid, 2*treeNode) + s.query(queryLeft, queryRight, mid+1, right, 2*treeNode+1)
}

func (s *segmentTree) update(index, value, treeNode, left, right int) {
    if treeNode >= len(s.tree) { return }
    if index < left || index > right { return }
    if left > right { return }
    if left == right { 
        s.tree[treeNode] = value
        return
    }
    mid := (left+right)/2
    s.update(index, value, 2*treeNode, left, mid)
    s.update(index, value, 2*treeNode + 1, mid+1, right)
    s.tree[treeNode] = s.tree[2*treeNode] + s.tree[2*treeNode+1]
}
