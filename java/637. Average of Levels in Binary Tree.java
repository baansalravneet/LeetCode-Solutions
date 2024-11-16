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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> answer = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int n = size;
            long sum = 0;
            while (size-- > 0) {
                TreeNode current = q.pollFirst();
                sum += current.val;
                if (current.left != null) q.addLast(current.left);
                if (current.right != null) q.addLast(current.right);
            }
            answer.add((double)sum / n);
        }
        return answer;
    }
}
