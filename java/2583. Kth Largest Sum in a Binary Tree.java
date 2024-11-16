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
    public long kthLargestLevelSum(TreeNode root, int k) {
        PriorityQueue<Long> sums = new PriorityQueue<>();
        Deque<TreeNode> level = new LinkedList<>();
        level.add(root);
        while (!level.isEmpty()) {
            int size = level.size();
            long sum = 0;
            while (size-- > 0) {
                TreeNode current = level.pollFirst();
                sum += current.val;
                if (current.left != null) level.addLast(current.left);
                if (current.right != null) level.addLast(current.right);
            }
            sums.add(sum);
            if (sums.size() > k) {
                sums.poll();
            }
        }
        if (sums.size() < k) return -1;
        int answer = 0;
        return sums.poll();
    }
}