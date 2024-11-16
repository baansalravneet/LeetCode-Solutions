/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func mergeInBetween(list1 *ListNode, a int, b int, list2 *ListNode) *ListNode {
	beforeA := getNode(list1, a-1)
	afterB := getNode(list1, b+1)
	beforeA.Next = list2
	for beforeA.Next != nil {
		beforeA = beforeA.Next
	}
	beforeA.Next = afterB
	return list1
 }

func getNode(head *ListNode, index int) *ListNode {
	for index > 0 {
		head = head.Next
		index -= 1
	}
	return head
}