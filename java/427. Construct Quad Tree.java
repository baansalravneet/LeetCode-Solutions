/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return helper(grid, 0, n-1, 0, n-1);
    }
    private Node helper(int[][] grid, int left, int right, int top, int bottom) {
        System.out.printf("%d %d %d %d\n", left, right, top, bottom);
        // check if the current grid has all 0s or 1s
        int zeros = 0;
        int ones = 0;
        int n = right - left;
        int total = 0;
        for (int i = top; i <= bottom; i++) {
            for (int j = left; j <= right; j++) {
                if (grid[i][j] == 1) ones++;
                else zeros++;
                total++;
            }
        }
        if (zeros == total) return new Node(false, true);
        if (ones == total) return new Node(true, true);

        // if not, make a new internal node and recursively find children
        int disp = n/2;
        return new Node(
            false,
            false,
            helper(grid, left, left+disp, top, top+disp),
            helper(grid, left+disp+1, right, top, top+disp),
            helper(grid, left, left+disp, top+disp+1, bottom),
            helper(grid, left+disp+1, right, top+disp+1, bottom)
        );
    }
}
