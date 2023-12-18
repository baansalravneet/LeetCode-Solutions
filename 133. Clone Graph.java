/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> visited = new HashMap<>();
        Node newHead = new Node(node.val);
        visited.put(newHead.val, newHead);
        dfs(node, visited, newHead);
        return newHead;
    }
    private void dfs(Node node, Map<Integer, Node> visited, Node newHead) {
        if (node == null || node.neighbors == null) {
            return;
        }
        for (Node next : node.neighbors) {
            // it's a backward edge
            if (!visited.containsKey(next.val)) {
                Node newNode = new Node(next.val);
                visited.put(next.val, newNode);
                dfs(next, visited, newNode);
            }
            newHead.neighbors.add(visited.get(next.val));
        }
    }
}
