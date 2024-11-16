class Solution {
    public int findTheWinner(int n, int k) {
        Node head = getLinkedList(n);
        Node pointer = head;
        while (pointer.next != pointer) {
            int count = k-1;
            while (count-- > 0) {
                pointer = pointer.next;
            }
            pointer.previous.next = pointer.next;
            pointer.next.previous = pointer.previous;
            pointer = pointer.next;
        }
        return pointer.index;
    }
    private Node getLinkedList(int n) {
        Node head = new Node(1);
        Node pointer = head;
        for (int i = 2; i <= n; i++) {
            Node friend = new Node(i);
            pointer.next = friend;
            friend.previous = pointer;
            pointer = pointer.next;
        }
        pointer.next = head;
        head.previous = pointer;
        return head;
    }
}

class Node {
    Node previous;
    Node next;
    int index;
    Node(int index) {
        this.index = index;
    }
}
