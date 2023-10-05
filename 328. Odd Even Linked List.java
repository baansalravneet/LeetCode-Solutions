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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        if (head.next.next == null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;
        ListNode pointer = head.next.next;
        boolean flag = true;
        while (pointer != null) {
            if (flag) {
                odd.next = pointer;
                odd = odd.next;
            } else {
                even.next = pointer;
                even = even.next;
            }
            pointer = pointer.next;
            flag = !flag;
        }
        even.next = null;
        odd.next = evenHead;
        return head;
    }
}
