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
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> bfsQ = new ArrayDeque<>();
        bfsQ.addLast(root);
        int level = 0;
        while (!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            int previous = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            while (size-- > 0) {
                TreeNode current = bfsQ.pollFirst();
                if (level % 2 == 0 && (current.val % 2 == 0 || current.val <= previous)) return false;
                if (level % 2 != 0 && (current.val % 2 != 0 || current.val >= previous)) return false;
                previous = current.val;
                if (current.left != null) bfsQ.addLast(current.left);
                if (current.right != null) bfsQ.addLast(current.right);
            }
            level++;
        }
        return true;
    }
}