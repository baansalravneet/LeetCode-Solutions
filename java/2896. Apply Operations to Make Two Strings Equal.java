class Solution {
    public int minOperations(String s1, String s2, int x) {
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff.add(i);
            }
        }
        if (diff.size() % 2 != 0) return -1;

        int m = diff.size();
        Integer[][] dp = new Integer[m][m];
        
        return helper(0, diff.size() - 1, diff, dp, x);
    }
    private int helper(int start, int end, List<Integer> diff, Integer[][] dp, int x) {
        if (start >= end) return 0;
        if (dp[start][end] != null) return dp[start][end];
        int result = Integer.MAX_VALUE;
        for (int i = start+1; i <= end; i += 2) {
            int current = Math.min(x, diff.get(i) - diff.get(start)) + helper(start + 1, i-1, diff, dp, x) + helper(i+1, end, diff, dp, x);
            result = Math.min(result, current);
        }
        return dp[start][end] = result;
    }
}
