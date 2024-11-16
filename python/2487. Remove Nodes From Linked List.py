# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNodes(self, head: Optional[ListNode]) -> Optional[ListNode]:
        reversed = self.reverse(head)
        pointer = reversed
        while pointer != None:
            while pointer.next != None and pointer.next.val < pointer.val:
                pointer.next = pointer.next.next
            pointer = pointer.next
        return self.reverse(reversed)
    def reverse(self, head):
        previous = None
        while head != None:
            temp = head.next
            head.next = previous
            previous = head
            head = temp
        return previous