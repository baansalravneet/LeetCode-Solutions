class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWait = 0;
        int previousFinish = customers[0][0];
        for (int[] cus : customers) {
            if (previousFinish <= cus[0]) {
                previousFinish = cus[0] + cus[1];
                totalWait += cus[1];
            } else {
                totalWait += previousFinish - cus[0] + cus[1];
                previousFinish += cus[1];
            }
        }
        return totalWait / customers.length;
    }
}
