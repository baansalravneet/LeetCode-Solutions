/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 func getDirections(root *TreeNode, startValue int, destValue int) string {
    path1, _ := find(root, startValue, []byte{})
    path2, _ := find(root, destValue, []byte{})
    for len(path1) > 0 && len(path2) > 0 && path1[0] == path2[0] {
        path1, path2 = path1[1:], path2[1:]
    }
    return strings.Repeat("U", len(path1)) + string(path2)
}

func find(root *TreeNode, val int, s []byte) ([]byte, bool) {
    if root == nil {
        return nil, false
    }
    if root.Val == val {
        return s, true
    }
    temp := append(s, 'L')
    if result, found := find(root.Left, val, temp); found {
        return result, true
    }
    return find(root.Right, val, append(s, 'R'))
}
