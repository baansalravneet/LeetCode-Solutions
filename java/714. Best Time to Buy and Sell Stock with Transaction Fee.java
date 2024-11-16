class Solution {
    public int maxProfit(int[] prices, int fee) {
        Integer[][] cache = new Integer[prices.length][2];
        return helper(prices, fee, 0, 0, cache);
    }
    private int helper(int[] prices, int fee, int index, int state, Integer[][] cache) {
        if (index >= prices.length) return 0;
        if (cache[index][state] != null) return cache[index][state];
        int answer = helper(prices, fee, index+1, state, cache);
        if (state == 0) {
            answer = Math.max(answer, -prices[index]-fee+helper(prices, fee, index+1, 1, cache));
        } else {
            answer = Math.max(answer, prices[index]+helper(prices, fee, index+1, 0, cache));
        }
        return cache[index][state] = answer;
    }
}