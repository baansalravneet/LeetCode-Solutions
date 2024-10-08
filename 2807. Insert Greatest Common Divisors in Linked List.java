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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode pointer = head;
        while (pointer.next != null) {
            pointer.next = new ListNode(gcd(pointer.val, pointer.next.val), pointer.next);
            pointer = pointer.next.next;
        }
        return head;
    }
    private int gcd(int a, int b) {
        if (a > b) return gcd(b, a);
        if (a == 0) return b;
        return gcd(b%a, a);
    }
}
