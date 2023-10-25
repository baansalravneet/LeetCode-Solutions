class Solution {
    public int palindromePartition(String s, int k) {
        Integer[][] dp = new Integer[s.length()][k+1];
        return helper(s, k, dp, 0);
    }
    private int helper
    (
        String s,
        int remainingPartitions,
        Integer[][] dp,
        int currentIndex
    )
    {
        if (currentIndex == s.length() || remainingPartitions < 0) {
            if (remainingPartitions == 0) return 0;
            return Integer.MAX_VALUE;
        }
        if (remainingPartitions < 0) return Integer.MAX_VALUE;
        if (dp[currentIndex][remainingPartitions] != null) return dp[currentIndex][remainingPartitions];
        int localAnswer = Integer.MAX_VALUE;
        for (int i = currentIndex; i < s.length(); i++) {
            String currentString = s.substring(currentIndex, i+1);
            int changesRequired = findRequiredChanges(currentString);
            int nextAnswer = helper(s, remainingPartitions-1, dp, i+1);
            if (nextAnswer != Integer.MAX_VALUE) {
                localAnswer = Math.min(localAnswer, changesRequired + nextAnswer);
            }
        }
        dp[currentIndex][remainingPartitions] = localAnswer;
        return localAnswer;
    }
    private int findRequiredChanges(String s) {
        int left = 0;
        int right = s.length()-1;
        int count = 0;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) count++;
            left++;
            right--;
        }
        return count;
    }
}
