class Solution {
    public int maxProfit(int k, int[] prices) {
        Integer[][][] cache = new Integer[prices.length][2][k];
        return helper(prices, 0, 0, 0, k, cache);
    }

    private int helper(int[] prices, int index, int done, int canBuy, int limit, Integer[][][] cache) {
        if (index >= prices.length) {
            return 0;
        }
        if (done >= limit) {
            return 0;
        }
        if (cache[index][canBuy][done] != null) {
            return cache[index][canBuy][done];
        }
        int answer = 0;
        answer = Math.max(answer, helper(prices, index+1, done, canBuy, limit, cache));
        if (canBuy == 0) {
            answer = Math.max(answer, -prices[index]+helper(prices, index+1, done, 1-canBuy, limit, cache));
        } else {
            answer = Math.max(answer, prices[index]+helper(prices, index+1, done+1, 1-canBuy, limit, cache));
        }
        return cache[index][canBuy][done] = answer;
    }
}
