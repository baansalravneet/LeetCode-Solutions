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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = getCount(head);
        int n = count / k;
        int remain = count % k;
        ListNode[] answer = new ListNode[k];
        ListNode[] pointers = new ListNode[k];
        int index = 0;
        while (head != null) {
            int group = remain-- > 0 ? n+1 : n;
            answer[index] = head;
            while (group-- > 1) {
                head = head.next;
            }
            ListNode next = head.next;
            head.next = null;
            head = next;
            index++;
        }
        return answer;
    }
    private int getCount(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}

