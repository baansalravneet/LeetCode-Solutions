class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] ins = new int[n+1];
        int[] outs = new int[n+1];
        for (int[] i : trust) {
            ins[i[1]]++;
            outs[i[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (ins[i] == n-1 && outs[i] == 0) return i;
        }
        return -1;
    }
}

