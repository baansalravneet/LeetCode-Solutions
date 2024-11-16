/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
 func countPairs(root *TreeNode, distance int) int {
    path := []byte{}
    paths := []string{}
    var findPaths func(*TreeNode)
    findPaths = func (current *TreeNode) {
        if current == nil {
            return
        }
        if current.Left == nil && current.Right == nil {
            paths = append(paths, string(path))
        }
        path = append(path, 'L')
        findPaths(current.Left)
        path = path[:len(path)-1]
        path = append(path, 'R')
        findPaths(current.Right)
        path = path[:len(path)-1]
    }
    findPaths(root)
    count := 0
    for i := 0; i < len(paths); i++ {
        for j := i+1; j < len(paths); j++ {
            if check(paths[i], paths[j]) <= distance {
                count++
            }
        }
    }
    return count
}
func check(s, t string) int {
    i, j := 0, 0
    for i < len(s) && j < len(t) {
        if s[i] != t[j] {
            break
        }
        i++
        j++
    }
    return len(s)-i + len(t)-j
}