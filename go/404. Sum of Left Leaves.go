/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func sumOfLeftLeaves(root *TreeNode) int {
	return helper(root, false)
}
func helper(root *TreeNode, left bool) int {
	if root == nil {
		return 0
	}
	if root.Left == nil && root.Right == nil {
		if left {
			return root.Val
		} else {
			return 0
		}
	}
	return helper(root.Left, true) + helper(root.Right, false)
}