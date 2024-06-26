/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func balanceBST(root *TreeNode) *TreeNode {
    nodes := []*TreeNode{}
    populate(&nodes, root)
    return balance(nodes, 0, len(nodes)-1)
}
func balance(nodes []*TreeNode, left, right int) *TreeNode {
    if left > right { return nil }
    if left == right {
        current := nodes[left]
        current.Left = nil
        current.Right = nil
        return current
    }
    mid := (left + right)/2
    current := nodes[mid]
    current.Left = balance(nodes, left, mid-1)
    current.Right = balance(nodes, mid+1, right)
    return current
}
func populate(nodes *[]*TreeNode, root *TreeNode) {
    if (root == nil) { return }
    populate(nodes, root.Left)
    *nodes = append(*nodes, root)
    populate(nodes, root.Right)
}

