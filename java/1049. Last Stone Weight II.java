class Solution {
    public int lastStoneWeightII(int[] stones) {
        int total = 0;
        for (int i : stones) {
            total += i;
        }
        Integer[][] cache = new Integer[stones.length][total];
        return helper(stones, 0, 0, 0, cache);
    }
    private int helper(int[] stones, int sumLeft, int sumRight, int index, Integer[][] cache) {
        if (index >= stones.length) {
            return Math.abs(sumLeft - sumRight);
        }
        if (cache[index][sumLeft] != null) return cache[index][sumLeft];
        return cache[index][sumLeft] = Math.min(
                helper(stones, sumLeft + stones[index], sumRight, index+1, cache),
                helper(stones, sumLeft, sumRight + stones[index], index+1, cache)
        );
    }
}
