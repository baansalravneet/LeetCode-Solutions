/**
 * Definition for a Node.
 * type Node struct {
 *     Val int
 *     Next *Node
 *     Random *Node
 * }
 */

func copyRandomList(head *Node) *Node {
    if head == nil {
        return nil
    }
    nodeMap := make(map[*Node]*Node)
    newHead := &Node{
        Val: head.Val,
    }
    nodeMap[head] = newHead
    pointer := head.Next
    current := newHead
    for pointer != nil {
        current.Next = &Node{
            Val: pointer.Val,
        }
        current = current.Next
        nodeMap[pointer] = current
        pointer = pointer.Next
    }
    pointer = head
    current = newHead
    for pointer != nil {
        random := pointer.Random
        current.Random = nodeMap[random]
        current, pointer = current.Next, pointer.Next
    }
    return newHead
}
