/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func levelOrder(root *TreeNode) [][]int {
    var answer [][]int
    if root == nil {
        return answer
    }
    q := []*TreeNode{root}
    idx := 0
    for len(q) > 0 {
        size := len(q)
        answer = append(answer, []int{})
        for size > 0 {
            current := q[0]
            q = q[1:]
            if current.Left != nil {
                q = append(q, current.Left)
            }
            if current.Right != nil {
                q = append(q, current.Right)
            }
            answer[idx] = append(answer[idx], current.Val)
            size--
        }
        idx++;
    }
    return answer
}
