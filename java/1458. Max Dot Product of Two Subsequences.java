class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int max1 = getMax(nums1);
        int min1 = getMin(nums1);
        int max2 = getMax(nums2);
        int min2 = getMin(nums2);
        if (max1 < 0 && min2 > 0) return max1 * min2;
        if (min1 > 0 && max2 < 0) return min1 * max2;
        
        int n = nums1.length;
        int m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                int answer = nums1[i]*nums2[j] + dp[i+1][j+1];
                dp[i][j] = Math.max(answer, Math.max(dp[i][j+1], dp[i+1][j]));
            }
        }
        // print(dp);
        return dp[0][0];
    }
    private void print(int[][] dp) {
        for (int[] i : dp) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    private int getMax(int[] n) {
        int answer = Integer.MIN_VALUE;
        for (int i : n) {
            answer = Math.max(answer, i);
        }
        return answer;
    }
    private int getMin(int[] n) {
        int answer = Integer.MAX_VALUE;
        for (int i : n) {
            answer = Math.min(answer, i);
        }
        return answer;
    }
}
