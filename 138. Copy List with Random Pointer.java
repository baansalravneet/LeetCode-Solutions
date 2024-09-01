/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> mapping = new HashMap<>();
        Node pointer = head;
        while (pointer != null) {
            mapping.put(pointer, new Node(pointer.val));
            pointer = pointer.next;
        }
        pointer = head;
        while (pointer != null) {
            Node node = mapping.get(pointer);
            if (pointer.next != null) {
                node.next = mapping.get(pointer.next);
            }
            if (pointer.random != null) {
                node.random = mapping.get(pointer.random);
            }
            pointer = pointer.next;
        }
        return mapping.get(head);
    }
}