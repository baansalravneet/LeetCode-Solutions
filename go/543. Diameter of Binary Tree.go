/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func diameterOfBinaryTree(root *TreeNode) int {
    length := 0
    dfs(root, &length)
    return length
}

func dfs(root *TreeNode, length *int) int {
    if root == nil {
        return 0
    }
    left := dfs(root.Left, length)
    right := dfs(root.Right, length)
    *length = max(*length, left + right)
    return max(left, right) + 1;
}
