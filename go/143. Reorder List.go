/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reorderList(head *ListNode)  {
    slow, fast := head, head.Next;
    for fast != nil && fast.Next != nil {
        slow, fast = slow.Next, fast.Next.Next;
    }
    second := slow.Next;
    slow.Next = nil;
    var prev *ListNode
    for second != nil {
        temp := second.Next
        second.Next = prev
        prev = second
        second = temp
    }
    head2 := head
    for prev != nil {
        temp := head2.Next;
        temp2 := prev.Next
        head2.Next = prev
        prev.Next = temp
        head2 = temp
        prev = temp2
    }
}

