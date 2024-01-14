class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        Integer[][] cache = new Integer[n][n];
        return 1+helper(n-1, 1, 1, cache);
    }
    private int helper(int remaining, int done, int clipboard, Integer[][] cache) {
        if (remaining < 0) return 10000;
        if (remaining == 0) return 0;
        if (clipboard > remaining) return 10000;
        if (cache[remaining][clipboard] != null) return cache[remaining][clipboard];
        int answer = 10000;
        // do not copy if you already have what's on the screen on your clipboard
        if (clipboard != done) {
            answer = Math.min(answer, 1 + helper(remaining, done, done, cache));
        }
        answer = Math.min(answer, 1 + helper(remaining-clipboard, done+clipboard, clipboard, cache));
        return cache[remaining][clipboard] = answer;
    }
}
