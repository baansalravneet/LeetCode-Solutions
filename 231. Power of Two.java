class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        long i = 1;
        while (i <= n && i <= Integer.MAX_VALUE) {
            if (i == n) return true;
            i = i << 1;
        }
        return false;
    }
}
