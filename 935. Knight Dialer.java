class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int[][] possibleMoves = new int[][] {
        {4,6},
        {6,8},
        {7,9},
        {4,8},
        {3,9,0},
        {},
        {1,7,0},
        {2,6},
        {1,3},
        {2,4}
    };
    public int knightDialer(int n) {
        Integer[][] dp = new Integer[10][n+1];
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += helper(dp, n-1, i);
            answer %= MOD;
        }
        return (int) answer;
    }
    private int helper(Integer[][] dp, int moves, int position) {
        if (moves == 0) return 1;
        if (position == 5) return 0;
        if (dp[position][moves] != null) return dp[position][moves];
        int[] next = possibleMoves[position];
        long answer = 0;
        for (int i : next) {
            answer += helper(dp, moves-1, i);
            answer %= MOD;
        }
        return dp[position][moves] = (int)answer;
    } 
}
