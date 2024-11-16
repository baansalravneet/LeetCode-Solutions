class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[] {-1,-1};
        answer[0] = search(nums, target, true);
        answer[1] = search(nums, target, false);
        return answer;
    }
    private int search(int[] nums, int target, boolean first) {
        int index = -1;
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                if (first) right = mid - 1;
                else left = mid + 1;
                continue;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return index;
    }
}
