class Solution {
    public int numTrees(int n) {
        Integer[] cache = new Integer[n+1];
        return helper(1, n, cache);
    }
    private int helper(int left, int right, Integer[] cache) {
        if (left >= right) return 1;
        if (cache[right-left+1] != null) return cache[right-left+1];
        int answer = 0;
        for (int i = left; i <= right; i++) {
            answer += helper(left, i-1, cache) * helper(i+1, right, cache);
        }
        return cache[right-left+1] = answer;
    }
}

