/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func bstToGst(root *TreeNode) *TreeNode {
    helper(root, 0)
    return root
}

func helper(root *TreeNode, value int) int {
    if root == nil { return 0 }
    rightValue := helper(root.Right, value)
    leftValue := helper(root.Left, rightValue + root.Val + value)
    subTreeSum := rightValue + leftValue + root.Val
    root.Val += rightValue + value
    return subTreeSum
}

