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
    int answer;
    public int distributeCoins(TreeNode root) {
        answer = 0;
        findAnswer(root);
        return answer;
    }
    private int findAnswer(TreeNode root) {
        if (root == null) return 0;
        int required = findAnswer(root.left) + findAnswer(root.right) + 1 - root.val;
        answer += Math.abs(required);
        return required;
    }
}