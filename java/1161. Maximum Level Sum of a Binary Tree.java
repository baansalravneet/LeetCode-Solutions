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
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        int answer = 0;
        int currentLevel = 1;
        int maxSum = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            int currentSum = 0;
            while (size-- > 0) {
                TreeNode current = q.pollFirst();
                currentSum += current.val;
                if (current.left != null) q.addLast(current.left);
                if (current.right != null) q.addLast(current.right);
            }
            if (currentSum > maxSum) {
                answer = currentLevel;
                maxSum = currentSum;
            }
            currentLevel++;
        }
        return answer;
    }
}