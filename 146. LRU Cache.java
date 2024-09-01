class LRUCache {
    private Node head;
    private Node tail;
    private int capacity;
    private Map<Integer, Node> pointers;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.pointers = new HashMap<>();
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
        if (!pointers.containsKey(key)) return -1;
        Node node = pointers.get(key);
        makeHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node = pointers.computeIfAbsent(key, k -> new Node(key, value));
        node.val = value;
        if (tail == null) tail = node;
        makeHead(node);
        if (pointers.size() > capacity) {
            pointers.remove(removeTail().key);
        }
    }

    private void makeHead(Node node) {
        if (head == node || head == null) {
            head = node;
            return;
        }
        makeFree(node);
        node.next = head;
        head.prev = node;
        head = node;
    }

    private Node removeTail() {
        Node tailNode = tail;
        tail = tailNode.prev;
        tail.next = null;
        return tailNode;
    }

    private void makeFree(Node node) {
        if (tail == node) {
            tail = tail.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.next = null;
        node.prev = null;
    }
}

class Node {
    int key;
    int val;
    Node next;
    Node prev;
    Node (int key, int val) {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */