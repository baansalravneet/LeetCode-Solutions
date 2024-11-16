/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNthFromEnd(head *ListNode, n int) *ListNode {
    length := findLength(head)
    if length == n {
        return head.Next
    }
    length = length - n - 1
    pointer := head
    for length > 0 {
        pointer = pointer.Next
        length--
    }
    pointer.Next = pointer.Next.Next
    return head
}
func findLength(pointer *ListNode) int {
    if pointer == nil {
        return 0
    }
    return 1 + findLength(pointer.Next)
}
