class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        List<List<Integer>> prefix = new ArrayList<>();
        for (int i = 0; i < piles.size(); i++) {
            List<Integer> arr = new ArrayList<>();
            arr.add(piles.get(i).get(0));
            for (int j = 1; j < piles.get(i).size(); j++) {
                arr.add(piles.get(i).get(j) + arr.get(j-1));
            }
            prefix.add(arr);
        }
        Integer[][] cache = new Integer[k+1][piles.size()];
        return helper(prefix, k, 0, cache);
    }
    private int helper(List<List<Integer>> piles, int toPick, int currentPile, Integer[][] cache) {
        if (currentPile >= piles.size()) return 0;
        if (toPick < 0) return 0;
        if (cache[toPick][currentPile) != null) return cache[toPick][currentPile];
        int currentPileSize = piles.get(currentPile).size();
        int answer = helper(piles, toPick, currentPile+1);
        for (int i = 0; i < Math.min(toPick, currentPileSize); i++) {
            answer = Math.max(answer, piles.get(currentPile).get(i) + helper(piles, toPick-i-1, currentPile+1));
        }
        return cache[toPick][currentPile] = answer;
    }
}

