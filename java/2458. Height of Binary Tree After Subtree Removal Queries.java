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
    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> subtreeHeight = new HashMap<>();
        Map<Integer, Integer> nodeLevel = new HashMap<>();
        Map<Integer, int[]> levelNodes = new HashMap<>();
        populate(root, subtreeHeight);
        populateBFS(root, subtreeHeight, nodeLevel, levelNodes);
        int totalHeight = subtreeHeight.get(root.val);
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int node = queries[i];
            int level = nodeLevel.get(node);
            int[] nodes = levelNodes.get(level);
            if (nodes[0] == node) {
                answer[i] = totalHeight - subtreeHeight.get(node)
                    + (nodes[1] != -1 ? subtreeHeight.get(nodes[1]) : -1);
            } else {
                answer[i] = totalHeight;
            }
        }
        return answer;
    }
    private int populate(TreeNode current, Map<Integer, Integer> subtreeHeight) {
        if (current == null) return -1;
        int left = populate(current.left, subtreeHeight);
        int right = populate(current.right, subtreeHeight);
        int height = Math.max(left, right) + 1;
        subtreeHeight.put(current.val, height);
        return height;
    }
    private void populateBFS(
        TreeNode root,
        Map<Integer, Integer> subtreeHeight,
        Map<Integer, Integer> nodeLevel,
        Map<Integer, int[]> levelNodes
    ) {
        Deque<TreeNode> q = new LinkedList<>();
        q.addLast(root);
        int currentLevel = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int[] nodes = {-1, -1};
            while (size-- > 0) {
                TreeNode current = q.pollFirst();
                nodeLevel.put(current.val, currentLevel);
                int height = subtreeHeight.get(current.val);
                if (nodes[0] == -1 || subtreeHeight.get(nodes[0]) < height) {
                    nodes[1] = nodes[0];
                    nodes[0] = current.val;
                } else if (nodes[1] == -1 || subtreeHeight.get(nodes[1]) < height) {
                    nodes[1] = current.val;
                }
                if (current.left != null) q.addLast(current.left);
                if (current.right != null) q.addLast(current.right);
            }
            levelNodes.put(currentLevel, nodes);
            currentLevel++;
        }
    }
}