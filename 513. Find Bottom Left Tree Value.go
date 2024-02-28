/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findBottomLeftValue(root *TreeNode) int {
    answer := 0
    queue := []*TreeNode{}
    queue = append(queue, root)
    for len(queue) > 0 {
        current := queue[0]
        queue = queue[1:]
        answer = current.Val
        if current.Right != nil {
            queue = append(queue, current.Right)
        }
        if current.Left != nil {
            queue = append(queue, current.Left)
        }
    }
    return answer
}
