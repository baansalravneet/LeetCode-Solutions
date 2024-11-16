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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode s1 = slow.next;
        slow.next = null;
        ListNode s2 = head;
        s2 = mergeSort(s2);
        s1 = mergeSort(s1);
        return merge(s1, s2);
    }
    private ListNode merge(ListNode s1, ListNode s2) {
        if (s1 == null) return s2;
        if (s2 == null) return s1;
        if (s1.val < s2.val) {
            s1.next = merge(s1.next, s2);
            return s1;
        } else {
            s2.next = merge(s1, s2.next);
            return s2;
        }
    }
}
