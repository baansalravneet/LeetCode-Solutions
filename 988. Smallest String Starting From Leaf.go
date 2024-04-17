/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func smallestFromLeaf(root *TreeNode) string {
	answer := string('z' + 1)
	var dfs func(*TreeNode, string)
	dfs = func(node *TreeNode, result string) {
		if node == nil {
			return
		}
		result = string('a'+node.Val) + result
		if node.Left == nil && node.Right == nil {
			if result < answer {
				answer = result
			}
		}
		dfs(node.Left, result)
		dfs(node.Right, result)
		result = result[1:]
	}
	dfs(root, "")
	return answer
}