/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func treeQueries(root *TreeNode, queries []int) []int {
    nodeLevel := make(map[int]int)     // node  -> level
    levelHeight := make(map[int][]int) // level -> heights 2 nodes
    nodeHeight := make(map[int]int)    // node  -> height
    totalHeight := dfs(root, nodeLevel, nodeHeight, levelHeight, 0)
    // fmt.Println(nodeLevel)
    // fmt.Println(levelHeight)
    // fmt.Println(nodeHeight)
    result := make([]int, len(queries))
    for i, q := range queries {
        level := nodeLevel[q]
        heights := levelHeight[level]
        if heights[1] == 0 {
            result[i] = totalHeight - nodeHeight[heights[0]] - 1
        } else if q != heights[0] && q != heights[1] {
            result[i] = totalHeight
        } else if q == heights[1] {
            result[i] = totalHeight
        } else {
            result[i] = totalHeight - nodeHeight[heights[0]] + nodeHeight[heights[1]]
        }
    }
    return result
}

func dfs(root *TreeNode, nodeLevel, nodeHeight map[int]int, levelHeight map[int][]int, level int) int {
    if root == nil { return 0 }
    if root.Left == nil && root.Right == nil {
        nodeLevel[root.Val] = level
        nodeHeight[root.Val] = 0
        if _, ok := levelHeight[level]; !ok {
            levelHeight[level] = make([]int, 2)
        }
        heights := levelHeight[level]
        if nodeHeight[heights[0]] <= 0 {
            heights[1], heights[0] = heights[0], root.Val
        } else if nodeHeight[heights[1]] <= 0 {
            heights[1] = root.Val
        }
        levelHeight[level] = heights
        return 0
    }

    leftHeight := dfs(root.Left, nodeLevel, nodeHeight, levelHeight, level + 1)
    rightHeight := dfs(root.Right, nodeLevel, nodeHeight, levelHeight, level + 1)
    height := max(leftHeight, rightHeight)+1

    nodeLevel[root.Val] = level
    if _, ok := levelHeight[level]; !ok {
        levelHeight[level] = make([]int, 2)
    }
    heights := levelHeight[level]
    if nodeHeight[heights[0]] < height {
        heights[1], heights[0] = heights[0], root.Val
    } else if nodeHeight[heights[1]] < height {
        heights[1] = root.Val
    }
    levelHeight[level] = heights
    nodeHeight[root.Val] = height
    return height
}
