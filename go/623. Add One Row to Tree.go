/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func addOneRow(root *TreeNode, val int, depth int) *TreeNode {
	if depth == 1 {
		return &TreeNode{val, root, nil}
	}
	q := []*TreeNode{root}
	for depth > 2 {
		size := len(q)
		for size > 0 {
			current := q[0]
			q = q[1:]
			if current.Left != nil {
				q = append(q, current.Left)
			}
			if current.Right != nil {
				q = append(q, current.Right)
			}
			size -= 1
		}
		depth -= 1
	}
	for _, node := range q {
		node.Left = &TreeNode{val, node.Left, nil}
		node.Right = &TreeNode{val, nil, node.Right}
	}
	return root
}