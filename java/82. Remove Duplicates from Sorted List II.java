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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newList = new ListNode();
        ListNode pointer = newList;
        while (head != null) {
            if (head.next == null || head.val != head.next.val) {
                pointer.next = head;
                head = head.next;
                pointer = pointer.next;
                continue;
            }
            while (head != null && head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                head = head.next;
            }
            if (head == null) {
                pointer.next = null;
                break;
            }
            pointer.next = head;
            pointer = pointer.next;
            head = head.next;
        }
        return newList.next;
    }
}
