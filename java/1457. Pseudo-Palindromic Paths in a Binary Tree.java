/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int answer = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        helper(root, new int[10]);
        return answer;
    }
    private void helper(TreeNode current, int[] count) {
        if (current == null) return;
        if (current.left == null && current.right == null) {
            count[current.val]++;
            if (check(count)) answer++;
            count[current.val]--;
            return;
        }
        count[current.val]++;
        helper(current.left, count);
        helper(current.right, count);
        count[current.val]--;
    }
    private boolean check(int[] count) {
        int odd = 0;
        for (int i : count) {
            if (i % 2 != 0) odd++;
        }
        return odd == 0 || odd == 1;
    }
}
