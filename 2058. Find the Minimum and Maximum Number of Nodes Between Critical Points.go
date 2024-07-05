/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
 func nodesBetweenCriticalPoints(head *ListNode) []int {
	var previous *ListNode = nil
	index, firstNode, previousNode := 0, -1, -1
	answer := []int{math.MaxInt32, math.MinInt32}
	for head != nil {
		if previous != nil && head.Next != nil &&
			((previous.Val < head.Val && head.Val > head.Next.Val) ||
				(previous.Val > head.Val && head.Val < head.Next.Val)) {
			if firstNode == -1 {
				firstNode = index
			}
			if previousNode != -1 {
				answer[0] = min(answer[0], index-previousNode)
			}
			answer[1] = max(answer[1], index-firstNode)
			previousNode = index
		}
		previous, head = head, head.Next
		index++
	}
	if answer[0] == math.MaxInt32 {
		return []int{-1, -1}
	}
	return answer
}