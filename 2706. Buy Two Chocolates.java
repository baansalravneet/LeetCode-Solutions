class Solution {
    public int buyChoco(int[] prices, int money) {
        int a = Math.min(prices[0], prices[1]);
        int b = Math.max(prices[0], prices[1]);
        for (int i = 2; i < prices.length; i++) {
            if (prices[i] < a) {
                b = a;
                a = prices[i];
            } else if (prices[i] < b) {
                b = prices[i];
            }
        }
        return (a+b>money) ? money : money-a-b;
    }
}
