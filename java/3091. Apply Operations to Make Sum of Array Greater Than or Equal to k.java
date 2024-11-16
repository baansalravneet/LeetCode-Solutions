class Solution {
    public int minOperations(int k) {
        int sqrt = (int)Math.sqrt(k);
        return sqrt - 1 + (k-1)/sqrt;
    }
}
