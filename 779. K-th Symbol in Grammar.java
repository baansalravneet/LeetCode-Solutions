class Solution {
    public int kthGrammar(int n, int k) {
        if (n == 1) return 0;
        long currentLength = (long)Math.pow(2, n-1);
        if (k <= currentLength/2) {
            return kthGrammar(n-1, k);
        } else {
            return kthGrammar(n-1, (int) ((long)k - currentLength/2)) == 1 ? 0 : 1;
        }
    }
}
