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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        getMap(root, adj);
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> bfsQ = new ArrayDeque<>();
        bfsQ.addLast(start);
        int answer = -1;
        while (!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            while (size-- > 0) {
                int current = bfsQ.pollFirst();
                if (visited.contains(current)) continue;
                visited.add(current);
                if (!adj.containsKey(current)) continue;
                for (int next : adj.get(current)) {
                    if (visited.contains(next)) continue;
                    bfsQ.addLast(next);
                }
            }
            answer++;
        }
        return answer;
    }
    private void getMap(TreeNode node, Map<Integer, Set<Integer>> adj) {
        if (node == null) return;
        if (node.left != null) {
            adj.computeIfAbsent(node.val, k -> new HashSet<>()).add(node.left.val);
            adj.computeIfAbsent(node.left.val, k -> new HashSet<>()).add(node.val);
        }
        if (node.right != null) {
            adj.computeIfAbsent(node.val, k -> new HashSet<>()).add(node.right.val);
            adj.computeIfAbsent(node.right.val, k -> new HashSet<>()).add(node.val);
        }
        getMap(node.left, adj);
        getMap(node.right, adj);
    }
}
