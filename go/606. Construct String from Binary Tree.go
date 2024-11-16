/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func tree2str(root *TreeNode) string {
    if root == nil {
        return ""
    }
    answer := strconv.Itoa(root.Val)
    if root.Left == nil && root.Right == nil {
        return answer
    }
    left := tree2str(root.Left)
    right := tree2str(root.Right)
    answer = answer + "(" + left + ")"
    if right != "" {
        answer = answer + "(" + right + ")"
    }
    return answer
}
