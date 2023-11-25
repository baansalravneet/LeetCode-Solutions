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
    private int answer = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return answer;
    }
    private void helper(TreeNode root, int current) {
        if (root == null) return;
        current *= 10;
        current += root.val;
        if (root.left == null && root.right == null) {
            answer += current;
            return;
        }
        helper(root.left, current);
        helper(root.right, current);
    }
}
