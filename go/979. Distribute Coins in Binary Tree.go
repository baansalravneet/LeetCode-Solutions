/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func distributeCoins(root *TreeNode) int {
	answer := 0
	var findAnswer func(root *TreeNode) int
	findAnswer = func(root *TreeNode) int {
		if root == nil {
			return 0
		}
		required := findAnswer(root.Left) + findAnswer(root.Right) + 1 - root.Val
		answer += int(math.Abs(float64(required)))
		return required
	}
	findAnswer(root)
	return answer
}