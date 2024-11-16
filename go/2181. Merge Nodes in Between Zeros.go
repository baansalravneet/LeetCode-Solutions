/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeNodes(head *ListNode) *ListNode {
	dummyHead := &ListNode{}
	pointer := dummyHead
	for head != nil {
		sum := 0
		head = head.Next
		for head != nil && head.Val != 0 {
			sum += head.Val
			head = head.Next
		}
		if sum == 0 {
			break
		}
		pointer.Next = &ListNode{Val: sum}
		pointer = pointer.Next
	}
	return dummyHead.Next
}