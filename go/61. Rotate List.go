/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func rotateRight(head *ListNode, k int) *ListNode {
    length := findLength(head)
    if length == 0 {
        return head
    }
    k = k % length
    if k == 0 {
        return head
    }
    newLast := findKthFromEnd(head, k+1, length)
    newHead := newLast.Next
    newLast.Next = nil
    oldLast := newHead
    for oldLast.Next != nil {
        oldLast = oldLast.Next
    }
    oldLast.Next = head
    return newHead
}

func findKthFromEnd(head *ListNode, k, length int) *ListNode {
    if k == length {
        return head
    }
    return findKthFromEnd(head.Next, k, length-1)
}

func findLength(head *ListNode) int {
    count := 0
    for head != nil {
        count, head = count+1, head.Next
    }
    return count
}
