class Solution {
    public int minInsertions(String s) {
        Integer[][] cache = new Integer[s.length()][s.length()];
        return helper(s, 0, s.length()-1, cache);
    }
    private int helper(String s, int left, int right, Integer[][] cache) {
        if (left >= right) {
            return 0;
        }
        if (cache[left][right] != null) {
            return cache[left][right];
        }
        if (s.charAt(left) == s.charAt(right)) {
            return cache[left][right] = helper(s, left+1, right-1, cache);
        }
        return cache[left][right] = 1 + Math.min(
            helper(s, left+1, right, cache),
            helper(s, left, right-1, cache)
            );
    }
}