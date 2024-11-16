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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) return answer;
        Deque<TreeNode> q = new ArrayDeque<>();
        boolean leftToRight = true;
        q.addLast(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> current = new ArrayList<>();
            while (size-- > 0) {
                TreeNode x = q.pollFirst();
                current.add(x.val);
                if (x.left != null) q.addLast(x.left);
                if (x.right != null) q.addLast(x.right);
            }
            if (leftToRight) {
                answer.add(current);
            } else {
                answer.add(reverse(current));
            }
            leftToRight = !leftToRight;
        }
        return answer;
    }
    private List<Integer> reverse(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n/2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(n-1-i));
            list.set(n-1-i, temp);
        }
        return list;
    }
}
