class Solution {
    public int maxCount(int[] b, int n, int maxSum) {
        boolean[] banned = new boolean[n+1];
        for (int i : b) {
            if (i >= banned.length) continue;
            banned[i] = true;
        }
        int count = 0;
        int sum = 0;
        for (int i = 1; i <= n && sum + i <= maxSum; i++) {
            if (banned[i]) continue;
            sum += i;
            count++;
        }
        return count;
    }
}
