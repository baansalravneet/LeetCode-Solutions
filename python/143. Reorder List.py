# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """
        slow, fast = head, head.next
        while fast != None and fast.next != None:
            slow, fast = slow.next, fast.next.next
        second = slow.next
        slow.next = None
        prev = None
        while second:
            temp = second.next
            second.next = prev
            prev = second
            second = temp
        head2 = head
        while prev:
            temp = head2.next
            temp2 = prev.next
            head2.next = prev
            prev.next = temp
            head2 = temp
            prev = temp2
        

