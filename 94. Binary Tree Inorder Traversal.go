/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func inorderTraversal(root *TreeNode) []int {
    answer := []int{}
    helper(root, &answer)
    return answer
}

func helper(root *TreeNode, answer *[]int) {
    if root == nil {
        return
    }
    helper(root.Left, answer)
    *answer = append(*answer, root.Val)
    helper(root.Right, answer)
}
