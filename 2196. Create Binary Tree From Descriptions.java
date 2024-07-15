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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] node : descriptions) {
            TreeNode current = nodeMap.computeIfAbsent(node[0], (key) -> new TreeNode(node[0]));
            TreeNode child = nodeMap.computeIfAbsent(node[1], (key) -> new TreeNode(node[1]));
            children.add(node[1]);
            boolean left = node[2] == 1;
            if (left) current.left = child;
            else current.right = child;
        }
        for (int[] node : descriptions) {
            if (!children.contains(node[0])) {
                return nodeMap.get(node[0]);
            }
        }
        return null;
    }
}