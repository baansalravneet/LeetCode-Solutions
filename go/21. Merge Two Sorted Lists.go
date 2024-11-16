/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
    var newHead *ListNode
    if list1 == nil {
        return list2
    }
    if list2 == nil {
        return list1
    }
    if list1.Val < list2.Val {
        newHead = list1
        list1 = list1.Next
    } else {
        newHead = list2
        list2 = list2.Next
    }
    pointer := newHead
    for list1 != nil && list2 != nil {
	if list1.Val < list2.Val {
	    pointer.Next = list1
	    list1 = list1.Next
	} else {
	    pointer.Next = list2
	    list2 = list2.Next
	}
	pointer = pointer.Next
    }
    if list1 != nil {
        pointer.Next = list1
    }
    if list2 != nil {
        pointer.Next = list2
    }
    return newHead
}
