class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 3000000;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canDo(nums, threshold, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    private boolean canDo(int[] nums, int th, int n) {
        int sum = 0;
        for (int i : nums) {
            sum += (int)Math.ceil(i/(double)n);
        }
        return sum <= th;
    }
}
