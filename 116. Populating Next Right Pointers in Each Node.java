/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node nextLevelStart = root;
        Node current = root;
        while(nextLevelStart != null) {
            current = nextLevelStart;
            nextLevelStart = null;
            Node nextLevelPointer = new Node(1);
            while (current != null) {
                if (nextLevelStart == null && current.left != null) {
                    nextLevelStart = current.left;
                }
                if (nextLevelStart == null && current.right != null) {
                    nextLevelStart = current.right;
                }
                if (current.left != null) {
                    nextLevelPointer.next = current.left;
                    nextLevelPointer = nextLevelPointer.next;
                }
                if (current.right != null) {
                    nextLevelPointer.next = current.right;
                    nextLevelPointer = nextLevelPointer.next;
                }
                current = current.next;
            }
        }
        return root;
    }
}
