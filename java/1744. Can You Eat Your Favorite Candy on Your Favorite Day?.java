class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        System.out.println(candiesCount.length);
        long[] prefix = new long[candiesCount.length];
        prefix[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            prefix[i] = prefix[i-1] + candiesCount[i];
        }
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int type = queries[i][0];
            long day = queries[i][1];
            long cap = queries[i][2];
            long canMax = cap * (day+1) - 1;
            long canMin = queries[i][1];
            long requiredMax = prefix[type]-1;
            long requiredMin = type > 0 ? prefix[type-1] : 0;
            result[i] = !(requiredMax < canMin || requiredMin > canMax);
        }
        return result;
    }
}


