/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func modifiedList(nums []int, head *ListNode) *ListNode {
    set := make(map[int]bool)
    for _, v := range nums {
        set[v] = true
    }
    newHead := &ListNode{}
    pointer := newHead
    for head != nil {
        if !set[head.Val] {
            pointer.Next = head
            pointer = pointer.Next
        }
        head = head.Next
    }
    pointer.Next = nil
    return newHead.Next
}

