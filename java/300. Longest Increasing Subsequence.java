class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] d = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = Integer.MIN_VALUE;
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int index = search(nums[i], d);
            if (index == n-1) return n;
            d[index+1] = nums[i];
            answer = Math.max(answer, index+1);
        }
        return answer;
    }
    private int search(int target, int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int index = -1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (arr[mid] < target) {
                index = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
