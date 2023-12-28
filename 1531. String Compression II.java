class Solution {
    public static final String keyFormat = "%d,%d,%c,%d";
    public int getLengthOfOptimalCompression(String s, int k) {
        Integer[][] cache = new Integer[s.length()+1][k+1];
        return helper(cache, s, 0, k);
    }

    private int helper(Integer[][] cache, String s, int index, int k) {
        if (s.length()-index <= k) { // if remaining characters is less than k, delete all
            return 0;
        }
        if (cache[index][k] != null) {
            return cache[index][k];
        }
        // if we can delete a character, try deleting. else, set a high value
        int result = k > 0 ? helper(cache, s, index + 1, k - 1) : 101;
        int remaining = k;
        int streak = 1;
        for (int j = index+1; j <= s.length(); j++) {
            int increment = 1;
            if (streak > 1) increment++;
            if (streak > 9) increment++;
            if (streak > 99) increment++;
            result = Math.min(result, increment + helper(cache, s, j, remaining));
            if (j < s.length() && s.charAt(index) == s.charAt(j)) {
                streak++;
            } else if (--remaining < 0) {
                break;
            }
        }
        return cache[index][k] = result;
    }
}

