class Solution {
    private static final int MOD = (int)1e9+7;
    public int ways(String[] pizza, int k) {
        Integer[][][] cache = new Integer[pizza.length][pizza[0].length()][k];
        return helper(k-1, 0, 0, pizza, cache);
    }
    private int helper(int remainingCuts, int row, int col, String[] pizza, Integer[][][] cache) {
        if (remainingCuts == 0) {
            if (containsApple(pizza, row, pizza.length-1, col, pizza[0].length()-1)) {
                return 1;
            }
            return 0;
        }
        if (cache[row][col][remainingCuts] != null) return cache[row][col][remainingCuts];
        int answer = 0;
        for (int i = row; i < pizza.length; i++) {
            if (
                    containsApple(pizza, row, i, col, pizza[0].length()-1) &&
                    containsApple(pizza, i+1, pizza.length-1, col, pizza[0].length()-1)
               ) {
                answer += helper(remainingCuts-1, i+1, col, pizza, cache);
                answer %= MOD;
           }
        }
        for (int j = col; j < pizza[0].length(); j++) {
            if (
                    containsApple(pizza, row, pizza.length-1, col, j) &&
                    containsApple(pizza, row, pizza.length-1, j+1, pizza[0].length()-1)
               ) {
                answer += helper(remainingCuts-1, row, j+1, pizza, cache);
                answer %= MOD;
            }
        }
        return cache[row][col][remainingCuts] = answer;
    }
    private boolean containsApple(String[] pizza, int rs, int re, int cs, int ce) {
        for (int i = rs; i <= re; i++) {
            for (int j = cs; j <= ce; j++) {
                if (pizza[i].charAt(j) == 'A') return true;
            }
        }
        return false;
    }
}
