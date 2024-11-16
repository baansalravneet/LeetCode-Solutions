class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int count = 0;
        int n = piles.length/3;
        for (int i = 1; i < piles.length && n > 0; i = i+2, n--) {
            count += piles[piles.length - 1 - i];
        }
        return count;
    }
}
