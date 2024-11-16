/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeZeroSumSublists(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }
    sum := 0
    pointer := head
    for pointer != nil {
        sum += pointer.Val
        pointer = pointer.Next
        if sum == 0 {
            return removeZeroSumSublists(pointer)
        }
    }
    head.Next = removeZeroSumSublists(head.Next)
    return head
}

