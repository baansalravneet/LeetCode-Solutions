class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer[][] cache = new Integer[text1.length()][text2.length()];
        return helper(text1, text2, 0, 0, cache);
    }
    private int helper(String text1, String text2, int i, int j, Integer[][] cache) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        if (cache[i][j] != null) return cache[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            return cache[i][j] = 1 + helper(text1, text2, i+1, j+1, cache);
        } else {
            return cache[i][j] = Math.max(helper(text1, text2, i+1, j, cache), helper(text1, text2, i, j+1, cache));
        }
    }
}
