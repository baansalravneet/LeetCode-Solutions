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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        helper(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return answer;
    }
    private void helper(TreeNode root, long targetSum, long currentSum) {
        if (root == null) return;
        currentSum += root.val;
        if (currentSum == targetSum) answer++;
        helper(root.left, targetSum, currentSum);
        helper(root.right, targetSum, currentSum);
    }
}

