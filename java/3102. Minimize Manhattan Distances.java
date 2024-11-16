class Solution {
    public int minimumDistance(int[][] points) {
        int[] result1 = maxManhattanDistance(points, -1);
        int[] result2 = maxManhattanDistance(points, result1[0]);
        int[] result3 = maxManhattanDistance(points, result1[1]);
        return Math.min(distance(points, result2[0], result2[1]), distance(points, result3[0], result3[1]));
    }
    private int distance(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
    private int[] maxManhattanDistance(int[][] points, int remove) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        int minDiff = Integer.MAX_VALUE;
        int maxSumIndex = 0;
        int minSumIndex = 0;
        int maxDiffIndex = 0;
        int minDiffIndex = 0;
        for (int i = 0; i < points.length; i++) {
            if (i != remove) {
                int sum = points[i][0] + points[i][1];
                int diff = points[i][0] - points[i][1];
                if (maxSum < sum) {
                    maxSum = sum;
                    maxSumIndex = i;
                }
                if (minSum > sum) {
                    minSum = sum;
                    minSumIndex = i;
                }
                if (maxDiff < diff) {
                    maxDiff = diff;
                    maxDiffIndex = i;
                }
                if (minDiff > diff) {
                    minDiff = diff;
                    minDiffIndex = i;
                }
            }
        }
        if (maxSum - minSum > maxDiff - minDiff) {
            return new int[] {maxSumIndex, minSumIndex};
        } else {
            return new int[] {maxDiffIndex, minDiffIndex};
        }
    }
}

