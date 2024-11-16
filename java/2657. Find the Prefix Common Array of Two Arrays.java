class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        boolean[] fa = new boolean[n];
        boolean[] fb = new boolean[n];
        int[] result = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            int a = A[i];
            int b = B[i];
            fa[a-1] = true;
            fb[b-1] = true;
            if (fa[a-1] && fb[a-1]) count++;
            if (a != b && fa[b-1] && fb[b-1]) count++;
            result[i] = count;
        }
        return result;
    }
}
