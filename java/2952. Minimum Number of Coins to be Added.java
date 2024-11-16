class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int count = 0;
        int maxPossible = 0;
        int index = 0;
        while (maxPossible < target) {
            if (index < coins.length && coins[index] <= maxPossible + 1) {
                maxPossible += coins[index++];
            } else {
                count++;
                maxPossible += maxPossible + 1;
            }
        }
        return count;
    }
}
