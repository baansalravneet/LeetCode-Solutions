/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Children []*Node
 * }
 */

func postorder(root *Node) []int {
    stack := make([]*Node, 0, 1000)
    result := []int{}
    for root != nil || len(stack) > 0 {
        if root == nil {
            root = stack[len(stack)-1]
            stack = stack[:len(stack)-1]
        }
        result = append(result, root.Val)
        if root.Children == nil {
            root = nil
            continue
        }
        for _, child := range root.Children {
            stack = append(stack, child)
        }
        root = nil
    }
    for i, j := 0, len(result)-1; i < j; i, j = i+1, j-1 {
        result[i], result[j] = result[j], result[i]
    }
    return result
}

