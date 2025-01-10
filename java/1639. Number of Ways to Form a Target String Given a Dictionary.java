class Solution {
    private static final int MOD = (int)(1e9) + 7;
    public int numWays(String[] words, String target) {
        int wordLength = words[0].length();
        if (wordLength < target.length()) return 0;
        int[][] wordDb = new int[wordLength][26];
        for (String w : words) {
            for (int i = 0; i < wordLength; i++) {
                wordDb[i][w.charAt(i)-'a']++;
            }
        }
        Integer[][] cache = new Integer[wordLength][target.length()];
        return helper(target, wordDb, 0, 0, cache);
    }
    private int helper(
        String target,
        int[][] wordDb,
        int targetIndex,
        int dbIndex,
        Integer[][] cache
    ) {
        if (targetIndex == target.length()) return 1;
        if (dbIndex == wordDb.length) return 0;
        if (cache[dbIndex][targetIndex] != null) return cache[dbIndex][targetIndex];
        long answer = helper(target, wordDb, targetIndex, dbIndex+1, cache);
        long ways = wordDb[dbIndex][target.charAt(targetIndex)-'a'];
        answer += ways * helper(target, wordDb, targetIndex+1, dbIndex+1, cache);
        answer %= MOD;
        return cache[dbIndex][targetIndex] = (int)answer;
    }
}
