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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(root, targetSum, answer, new LinkedList<>());
        return answer;
    }
    private void helper(TreeNode root, int targetSum, List<List<Integer>> answer, LinkedList<Integer> current) {
        if (root == null) return;
        current.addLast(root.val);
        if (root.left == null & root.right == null) {
            if (targetSum == root.val) {
                answer.add(new ArrayList<>(current));
            }
            current.pollLast();
            return;
        }
        helper(root.left, targetSum - root.val, answer, current);
        helper(root.right, targetSum - root.val, answer, current);
        current.pollLast();
    }
}
