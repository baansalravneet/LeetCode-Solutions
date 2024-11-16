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
    public TreeNode recoverFromPreorder(String traversal) {
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        int i = 0;
        int value = 0;
        while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
            value *= 10;
            value += traversal.charAt(i) - '0';
            i++;
        }
        TreeNode root = new TreeNode(value);
        stack.add(new Pair(root, 0));
        while (i < traversal.length()) {
            int currentDepth = 0;
            while (!Character.isDigit(traversal.charAt(i))) {
                currentDepth++;
                i++;
            }
            int v = 0;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                v *= 10;
                v += traversal.charAt(i)-'0';
                i++;
            }
            TreeNode current = new TreeNode(v);
            if (currentDepth == stack.peekLast().getValue() + 1) {
                TreeNode parent = stack.peekLast().getKey();
                if (parent.left == null) {
                    parent.left = current;
                } else {
                    parent.right = current;
                    stack.pollLast();
                }
            } else if (currentDepth == stack.peekLast().getValue()) {
                stack.pollLast();
                TreeNode parent = stack.pollLast().getKey();
                parent.right = current;
            } else {
                while(stack.peekLast().getValue() >= currentDepth) {
                    stack.pollLast();
                }
                TreeNode parent = stack.pollLast().getKey();
                parent.right = current;
            }
            stack.addLast(new Pair(current, currentDepth));
        }
        return root;
    }
}
