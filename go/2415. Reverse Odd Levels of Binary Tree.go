/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func reverseOddLevels(root *TreeNode) *TreeNode {
    helper(root.Left, root.Right, 0)
    return root
}

func helper(left, right *TreeNode, depth int) {
    if left == nil || right == nil {
        return
    }
    if depth % 2 == 0 {
        left.Val, right.Val = right.Val, left.Val
    }
    helper(left.Left, right.Right, depth+1)
    helper(left.Right, right.Left, depth+1)
}

