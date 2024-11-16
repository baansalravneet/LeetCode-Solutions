# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        beforeA = self.getNode(list1, a-1)
        afterB = self.getNode(list1, b+1)
        beforeA.next = list2
        while beforeA.next:
            beforeA = beforeA.next
        beforeA.next = afterB
        return list1
    def getNode(self, node, index):
        for i in range(index):
            node = node.next
        return node
        