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
    public TreeNode replaceValueInTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        int previous = root.val;
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int currentSum = 0;
            while (size-- > 0) {
                TreeNode current = queue.pollFirst();
                current.val = previous - current.val;
                int leftRightSum = 0;
                if (current.left != null) {
                    leftRightSum += current.left.val;
                    queue.addLast(current.left);
                }
                if (current.right != null) {
                    leftRightSum += current.right.val;
                    queue.addLast(current.right);
                }
                if (current.left != null) current.left.val = leftRightSum;
                if (current.right != null) current.right.val = leftRightSum;
                currentSum += leftRightSum;
            }
            previous = currentSum;
        }
        return root;
    }
}