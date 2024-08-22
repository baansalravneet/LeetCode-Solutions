class Solution {
    public int strangePrinter(String s) {
        s = removeDuplicates(s);
        int n = s.length();
        Integer[][] cache = new Integer[n][n];
        return helper(0, s.length()-1, s, cache);
    }

    private int helper(int start, int end, String s, Integer[][] cache) {
        if (start > end) return 0;
        if (cache[start][end] != null) return cache[start][end];
        int answer = 1+helper(start+1, end, s, cache);
        for (int k = start+1; k <= end; k++) {
            if (s.charAt(start) == s.charAt(k)) {
                answer = Math.min(
                    answer,
                    helper(start, k-1, s, cache) + helper(k+1, end, s, cache)
                );
            }
        }
        return cache[start][end] = answer;
    }

    private String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            char current = s.charAt(i);
            sb.append(current);
            while (i < s.length() && current == s.charAt(i)) {
                i++;
            }
        }
        return sb.toString();
    }
}

