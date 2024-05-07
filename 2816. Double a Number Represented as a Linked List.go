/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func doubleIt(head *ListNode) *ListNode {
	reversed := reverse(head)
	newHead := &ListNode{Val: 0}
	pointer := newHead
	carry := 0
	for reversed != nil {
		pointer.Next = &ListNode{Val: (reversed.Val*2 + carry) % 10}
		carry = (reversed.Val*2 + carry) / 10
		reversed = reversed.Next
		pointer = pointer.Next
	}
	if carry != 0 {
		pointer.Next = &ListNode{Val: carry}
	}
	return reverse(newHead.Next)
}
func reverse(head *ListNode) *ListNode {
	var prev *ListNode
	for head != nil {
		head.Next, prev, head = prev, head, head.Next
	}
	return prev
}