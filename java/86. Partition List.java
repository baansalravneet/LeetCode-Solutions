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
    public ListNode partition(ListNode head, int x) {
       ListNode smaller = new ListNode(0);
       ListNode greater = new ListNode(0);
       ListNode smallPointer = smaller;
       ListNode bigPointer = greater;
       while (head != null) {
           if (head.val < x) {
               smallPointer.next = head;
               smallPointer = smallPointer.next;
           } else {
               bigPointer.next = head;
               bigPointer = bigPointer.next;
           }
           head = head.next;
       }
       if (smaller.next == null) return greater.next;
       if (greater.next == null) return smaller.next;
       bigPointer.next = null;
       smallPointer.next = greater.next;
       return smaller.next;
    }
}
