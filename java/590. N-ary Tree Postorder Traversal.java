/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            if (root == null) root = stack.pollLast();
            result.add(root.val);
            if (root.children == null) {
                root = null;
                continue;
            }
            for (Node child : root.children) {
                stack.addLast(child);
            }
            root = null;
        }
        for (int i = 0, j = result.size()-1; i < j; i++, j--) {
            int temp = result.get(i);
            result.set(i, result.get(j));
            result.set(j, temp);
        }
        return result;
    }
}

