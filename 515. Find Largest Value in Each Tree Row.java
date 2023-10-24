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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        if (root == null) return answer;
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int maxValue = Integer.MIN_VALUE;
            while (size-- > 0) {
                TreeNode current = q.pollFirst();
                maxValue = Math.max(maxValue, current.val);
                if (current.left != null) q.addLast(current.left);
                if (current.right != null) q.addLast(current.right);
            }
            answer.add(maxValue);
        }
        return answer;
    }
}
