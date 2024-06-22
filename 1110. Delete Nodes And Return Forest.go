/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func delNodes(root *TreeNode, to_delete []int) []*TreeNode {
    delMap := make(map[int]bool)
    for _, v := range to_delete {
        delMap[v] = true
    }
    return helper(root, nil, delMap, true)
}
func helper(root, parent *TreeNode, delMap map[int]bool, leftChild bool) []*TreeNode {
    result := []*TreeNode{}
    if root == nil {
        return result
    }
    if delMap[root.Val] {
        result = append(result, helper(root.Left, nil, delMap, true)...)
        result = append(result, helper(root.Right, nil, delMap, false)...)
        if parent != nil {
            if leftChild {
                parent.Left = nil
            } else {
                parent.Right = nil
            }
        }
    } else {
        if parent == nil {
            result = append(result, root)
        }
        result = append(result, helper(root.Left, root, delMap, true)...)
        result = append(result, helper(root.Right, root, delMap, false)...)
    }
    return result
}

