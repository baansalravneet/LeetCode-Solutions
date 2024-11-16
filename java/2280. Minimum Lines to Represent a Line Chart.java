class Solution {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1) return 0;
        Arrays.sort(stockPrices, (a,b) -> a[0] - b[0]);
        int count = 1;
        for (int i = 1; i < stockPrices.length-1; i++) {
            int[] x = stockPrices[i-1];
            int[] y = stockPrices[i];
            int[] z = stockPrices[i+1];
            if ((((long)y[0] - z[0])*((long)x[1]-y[1])) != (((long)x[0] - y[0])*((long)y[1]-z[1]))) {
                count++;
            }
        }
        return count;
    }
}
