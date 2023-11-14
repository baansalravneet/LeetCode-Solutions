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
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<NodeDisplacement> q = new LinkedList<>();
        q.add(new NodeDisplacement(root, 0));
        int answer = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            int leftMost = q.peekFirst().index;
            int rightMost = leftMost;
            while (size-- > 0) {
                NodeDisplacement current = q.pollFirst();
                if (current.node.left != null) {
                    q.addLast(new NodeDisplacement(current.node.left, 2*current.index + 1));
                }
                if (current.node.right != null) {
                    q.addLast(new NodeDisplacement(current.node.right, 2*current.index + 2));
                }
                rightMost = current.index;
            }
            answer = Math.max(rightMost - leftMost + 1, answer);
        }
        return answer;
    }
}

class NodeDisplacement {
    TreeNode node;
    int index;
    NodeDisplacement(TreeNode node, int index) {
        this.node = node;
        this.index = index;
    }
}
