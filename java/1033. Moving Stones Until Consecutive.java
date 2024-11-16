class Solution {
    public int[] numMovesStones(int a, int b, int c) {
        if (a > b || b > c || a > c) {
            if (a > b) return numMovesStones(b, a, c);
            if (b > c) return numMovesStones(a, c, b);
            if (a > c) return numMovesStones(c, b, a);
        }
        if (a == b-1 && c == b+1) return new int[] {0, 0};
        if (a == b-1) return new int[] {1, c-b-1};
        if (c == b+1) return new int[] {1, b-a-1};
        if (a == b-2 || b == c-2) return new int[] {1, c-b-1+b-a-1};
        return new int[] {2, c-b-1+b-a-1};
    }
}

