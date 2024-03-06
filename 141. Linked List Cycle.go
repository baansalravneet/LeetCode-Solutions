/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func hasCycle(head *ListNode) bool {
    if head == nil {
        return false
    }
    return check(head, head.Next)
}
func check(slow, fast *ListNode) bool {
    if fast == nil || fast.Next == nil {
        return false
    }
    if slow == fast {
        return true
    }
    return check(slow.Next, fast.Next.Next)
}

