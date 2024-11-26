class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] childNodes = new boolean[n];
        int count = 0;
        for (int[] e : edges) {
            if (!childNodes[e[1]]) count++;
            childNodes[e[1]] = true;
        }
        if (count != n-1) return -1;
        for (int i = 0; i < n; i++) {
            if (childNodes[i]) continue;
            return i;
        }
        return -1;
    }
}
