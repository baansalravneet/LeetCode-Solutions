class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int maxQuantity = 0;
        long sum = 0;
        for (int i : quantities) {
            maxQuantity = Math.max(maxQuantity, i);
            sum += (long) i;
        }
        int left = 0;
        int right = maxQuantity;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(n, mid, quantities, sum)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    private boolean isPossible(int n, int max, int[] quantities, long sum) {
        if ((long)n*max < sum) return false;
        int stores = 0;
        for (int i = 0; i < quantities.length; i++) {
            int current = quantities[i];
            int count = (int)Math.ceil((double)current / max);
            stores += count;
        }
        return stores <= n;
    }
}