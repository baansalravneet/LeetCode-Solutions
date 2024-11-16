class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int right = nums[n-1]-nums[0];
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            int count = getCount(nums, mid);
            if (count < k) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
    private int getCount(int[] nums, int k) {
        int left = 0;
        int answer = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > k) {
                left++;
            }
            answer += right - left;
        }
        return answer;
    }
}