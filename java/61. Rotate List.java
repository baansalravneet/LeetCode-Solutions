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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int n = findLength(head);
        k = k % n;
        if (k == 0) return head;
        int count = 0;
        ListNode pointer = head;
        ListNode newTail = null;
        ListNode newHead = null;
        while (count < n-k-1) {
            pointer = pointer.next;
            count++;
        }
        newTail = pointer;
        newHead = pointer.next;
        ListNode oldTail = null;
        while (count < n-1) {
            pointer = pointer.next;
            count++;
        }
        oldTail = pointer;
        newTail.next = null;
        oldTail.next = head;
        return newHead;
    }
    private int findLength(ListNode head) {
        if (head == null) return 0;
        return 1 + findLength(head.next);
    }
}
