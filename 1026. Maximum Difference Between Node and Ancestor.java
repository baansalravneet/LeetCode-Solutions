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
    public int maxAncestorDiff(TreeNode root) {
        answer = 0;
        helper(root);
        return answer;
    }
    private Pair<Integer, Integer> helper(TreeNode root) {
        if (root == null) return null;
        Pair<Integer, Integer> left = helper(root.left);
        Pair<Integer, Integer> right = helper(root.right);
        Pair<Integer, Integer> pair = new Pair(root.val, root.val);
        if (left != null) {
           answer = Math.max(answer, Math.abs(root.val - left.getKey()));
           answer = Math.max(answer, Math.abs(root.val - left.getValue()));
           pair = new Pair(Math.min(pair.getKey(), left.getKey()), Math.max(pair.getValue(), left.getValue()));
        }
        if (right != null) {
            answer = Math.max(answer, Math.abs(root.val - right.getKey()));
            answer = Math.max(answer, Math.abs(root.val - right.getValue()));
            pair = new Pair(Math.min(pair.getKey(), right.getKey()), Math.max(pair.getValue(), right.getValue()));
        }
        return pair;
    }
}

