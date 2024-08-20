class Solution {
    public int stoneGameII(int[] piles) {
        int[] suffix = Arrays.copyOf(piles, piles.length);
        for (int i = piles.length-2; i >= 0; i--) {
            suffix[i] += suffix[i+1];
        }
        Integer[][] cache = new Integer[piles.length][piles.length];
        return helper(piles, 0, 1, suffix, cache);
    }
    private int helper(int[] piles, int index, int m, int[] suffix, Integer[][] cache) {
        if (index + 2*m >= piles.length) return suffix[index];
        if (cache[index][m] != null) return cache[index][m];
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= 2*m; i++) {
            answer = Math.min(answer, helper(piles, index+i, Math.max(i, m), suffix, cache));
        }
        return cache[index][m] = suffix[index] - answer;
    }
}
