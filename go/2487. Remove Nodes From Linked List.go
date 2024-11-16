/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func removeNodes(head *ListNode) *ListNode {
	reversed := reverse(head)
	pointer := reversed
	for pointer != nil {
		for pointer.Next != nil && pointer.Next.Val < pointer.Val {
			pointer.Next = pointer.Next.Next
		}
		pointer = pointer.Next
	}
	return reverse(reversed)
}
func reverse(head *ListNode) *ListNode {
	var previous *ListNode
	for head != nil {
		temp := head.Next
		head.Next = previous
		previous = head
		head = temp
	}
	return previous
}