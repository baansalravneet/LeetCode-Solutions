/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode nodeBeforeA = getNode(list1, a-1);
        ListNode nodeAfterB = getNode(list1, b+1);
        nodeBeforeA.next = list2;
        while (nodeBeforeA.next != null) nodeBeforeA = nodeBeforeA.next;
        nodeBeforeA.next = nodeAfterB;
        return list1;
    }
    private ListNode getNode(ListNode head, int count) {
        while (count-- > 0) head = head.next;
        return head;
    }
}