class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        Boolean[][][] cache = new Boolean[n][n][n+1];
        return helper(s1, s2, 0, 0, n, cache);
    }
    private boolean helper(String s1, String s2, int s1Start, int s2Start, int length, Boolean[][][] cache) {
        if (length == 1) {
            return s1.charAt(s1Start) == s2.charAt(s2Start);
        }
        if (cache[s1Start][s2Start][length] != null) {
            return cache[s1Start][s2Start][length];
        }
        for (int i = 1; i < length; i++) {
            if (
                    helper(s1, s2, s1Start, s2Start, i, cache) &&
                    helper(s1, s2, s1Start + i, s2Start+i, length-i, cache)
               ) return cache[s1Start][s2Start][length] = true;
            if (
                    helper(s1, s2, s1Start, s2Start+length-i, i, cache) &&
                    helper(s1, s2, s1Start+i, s2Start, length-i, cache)
               ) return cache[s1Start][s2Start][length] = true;
        }
        return cache[s1Start][s2Start][length] = false;
    }
}


