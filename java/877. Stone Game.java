class Solution {
    public boolean stoneGame(int[] piles) {
        Boolean[][] cache = new Boolean[piles.length][piles.length];
        return helper(piles, 0, piles.length-1, 0, true, cache);
    }
    private boolean helper(int[] piles,
                           int left,
                           int right,
                           int current,
                           boolean turn,
                           Boolean[][] cache) {
        if (left > right) return current > 0;
        if (cache[left][right] != null) return cache[left][right];
        if (turn) {
            return cache[left][right] =
                    helper(piles, left+1, right, current+piles[left], !turn, cache) ||
                    helper(piles, left, right-1, current+piles[right], !turn, cache);
        } else {
            return cache[left][right] = 
                    helper(piles, left+1, right, current-piles[left], !turn, cache) ||
                    helper(piles, left, right-1, current-piles[right], !turn, cache);
        }
    }
}
