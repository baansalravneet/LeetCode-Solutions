class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        if (checkOneMove(a, b, c, d, e, f)) {
            return 1;
        }
        return 2;
    }
    private boolean checkOneMove(int a, int b, int c, int d, int e, int f) {
        // rook can see the queen
        if (a == e) {
            if (a != c) return true;
            if (d < Math.min(b, f) || d > Math.max(b, f)) return true;
        }
        if (b == f) {
            if (b != d) return true;
            if (c < Math.min(a, e) || c > Math.max(a, e)) return true;
        }
        // bishop can see the queen
        if (Math.abs(c - e) == Math.abs(d - f)) {
            if (Math.abs(a - c) != Math.abs(b - d)) return true;
            if (Math.abs(a - e) != Math.abs(b - f)) return true;
            if (a < Math.min(c, e) || a  > Math.max(c, e)) return true;
        }
        return false;
    }
}
