/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func middleNode(head *ListNode) *ListNode {
    length := getLength(head)
    length /= 2
    for length > 0 {
        head = head.Next
        length--
    }
    return head
}
func getLength(pointer *ListNode) int {
    count := 0
    for pointer != nil {
        count++
        pointer = pointer.Next
    }
    return count
}


