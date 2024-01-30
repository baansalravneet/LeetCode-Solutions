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
    public int[] nextLargerNodes(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        ListNode reversed = reverse(head);
        while (reversed != null) {
            while (!stack.isEmpty() && stack.peekLast() <= reversed.val) {
                stack.pollLast();
            }
            if (stack.isEmpty()) {
                result.add(0);
            } else {
                result.add(stack.peekLast());
            }
            stack.addLast(reversed.val);
            reversed = reversed.next;
        }
        int[] answer = new int[result.size()];
        int i = answer.length-1;
        for (int x : result) {
            answer[i--] = x;
        }
        return answer;
    }
    private ListNode reverse(ListNode head) {
        ListNode previous = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = previous;
            previous = head;
            head = temp;
        }
        return previous;
    }
}

