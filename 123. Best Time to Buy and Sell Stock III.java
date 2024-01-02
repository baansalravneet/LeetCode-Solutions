class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] cache = new Integer[prices.length][5];
        return helper(prices, 0, 1, cache);
    }
    private int helper(int[] prices, int index, int state, Integer[][] cache) {
        if (index >= prices.length) {
            return 0;
        }
        if (state == 5) {
            return 0;
        }
        if (cache[index][state] != null) {
            return cache[index][state];
        }
        int answer = 0;
        if (state == 1 || state == 3) {
            answer = Math.max(answer, -prices[index]+helper(prices, index+1, state+1, cache));
        }
        if (state == 2 || state == 4) {
            answer = Math.max(answer, prices[index]+helper(prices, index+1, state+1, cache));
        }
        answer = Math.max(answer, helper(prices, index+1, state, cache));
        return cache[index][state] = answer;
    }
}

