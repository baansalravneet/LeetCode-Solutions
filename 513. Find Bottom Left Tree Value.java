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
    public int findBottomLeftValue(TreeNode root) {
        int answer = 0;
        Deque<TreeNode> bfsQ = new ArrayDeque<>();
        bfsQ.addLast(root);
        while (!bfsQ.isEmpty()) {
            TreeNode current = bfsQ.pollFirst();
            answer = current.val;
            if (current.right != null) bfsQ.addLast(current.right);
            if (current.left != null) bfsQ.addLast(current.left);
        }
        return answer;
    }
}
