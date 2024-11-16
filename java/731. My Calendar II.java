class MyCalendarTwo {

    private SegmentTreeNode root;

    public MyCalendarTwo() {
    }
    
    public boolean book(int start, int end) {
        if (!insertable(start, end, root)) return false;
        root = insert(start, end, root);
        return true;
    }

    private SegmentTreeNode insert(int start, int end, SegmentTreeNode current) {
        if (start >= end) return current;
        if (current == null) return new SegmentTreeNode(start, end);
        if (start >= current.end) {
            current.right = insert(start, end, current.right);
        } else if (end <= current.start) {
            current.left = insert(start, end, current.left);
        } else {
            current.overlap = true;
            int a = Math.min(current.start, start);
            int b = Math.max(current.start, start);
            int c = Math.min(current.end, end);
            int d = Math.max(current.end, end);
            current.left = insert(a, b, current.left);
            current.right = insert(c, d, current.right);
            current.start = b;
            current.end = c;
        }
        return current;
    }
    
    private boolean insertable(int start, int end, SegmentTreeNode current) {
        if (start >= end) return true;
        if (current == null) return true;
        if (start >= current.end) return insertable(start, end, current.right);
        if (end <= current.start) return insertable(start, end, current.left);
        if (current.overlap) return false;
        if (start >= current.start && end <= current.end) return true;
        return insertable(start, end, current.left) && insertable(start, end, current.right);
    }
}

class SegmentTreeNode {
    int start, end;
    boolean overlap;
    SegmentTreeNode left, right;
    SegmentTreeNode(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */