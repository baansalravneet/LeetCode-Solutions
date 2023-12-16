/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(preorder []int, inorder []int) *TreeNode {
    inorderIndex := make(map[int]int)
    for i, node := range inorder {
        inorderIndex[node] = i
    }
    return helper(&preorder, &inorder, &inorderIndex, 0, len(inorder)-1, 0)
}

func helper(preorder, inorder *[]int, inorderIndex *map[int]int, left, right, index int) *TreeNode {
    if left > right {
        return nil
    }
    if left == right {
        return &TreeNode {
            Val: (*inorder)[left],
        }
    }
    current := (*preorder)[index]
    mid := (*inorderIndex)[current]
    return &TreeNode {
        Val: current,
        Left: helper(preorder, inorder, inorderIndex, left, mid-1, index+1),
        Right: helper(preorder, inorder, inorderIndex, mid+1, right, index + mid - left + 1),
    }
}
