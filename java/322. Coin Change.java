class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer[][] cache = new Integer[coins.length+1][amount+1];
        return (int)helper(coins, amount, 0, cache);
    }
    
    private long helper(int[] coins, int amountRemaining, int index, Integer[][] cache) {
        if (amountRemaining == 0) {
            return 0;
        }
        if (amountRemaining < 0) {
            return -1;
        }
        if (amountRemaining > 0 && index >= coins.length) {
            return -1;
        }
        if (cache[index][amountRemaining] != null) {
            return cache[index][amountRemaining];
        }

        long choice1 = helper(coins, amountRemaining-coins[index], index, cache);
        long choice2 = helper(coins, amountRemaining, index+1, cache);
        long result = Integer.MAX_VALUE;
        if (choice1 != -1) {
            result = Math.min(result, 1+choice1);
        }
        if (choice2 != -1) {
            result = Math.min(result, choice2);
        }
        result = result == Integer.MAX_VALUE ? -1 : result;
        return cache[index][amountRemaining] = (int)result;
    }
}
