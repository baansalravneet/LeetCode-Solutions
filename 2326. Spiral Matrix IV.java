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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        for (int[] i : result) Arrays.fill(i, -1);
        int top = -1, left = -1, right = n, bottom = m;
        int dir = 0;
        int x = 0, y = 0;
        while (head != null) {
            result[x][y] = head.val;
            head = head.next;
            if (dir == 0) {
                y++;
                if (y == right) {
                    y--;
                    x++;
                    dir = 1;
                    top++;
                }
            } else if (dir == 1) {
                x++;
                if (x == bottom) {
                    x--;
                    y--;
                    dir = 2;
                    right--;
                }
            } else if (dir == 2) {
                y--;
                if (y == left) {
                    y++;
                    x--;
                    dir = 3;
                    bottom--;
                }
            } else {
                x--;
                if (x == top) {
                    x++;
                    y++;
                    dir = 0;
                    left++;
                }
            }
        }
        return result;
    }
}


