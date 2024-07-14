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
	newList := &ListNode{0, head}
	pointer := newList
	for head != nil {
		for head != nil && set[head.Val] {
			head = head.Next
		}
		pointer.Next = head
		pointer = pointer.Next
		if head != nil {
			head = head.Next
		}
	}
	return newList.Next
}
