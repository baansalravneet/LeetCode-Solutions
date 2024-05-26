class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        int maxValue = Integer.MIN_VALUE;
        for (int i : nums) maxValue = Math.max(maxValue, i);
        int[] count = new int[maxValue+1];
        return find(nums, k, count, 0)-1;
    }
    private int find(int[] nums, int k, int[] count, int index) {
        if (index >= nums.length) return 1;
        int answer = find(nums, k, count, index+1);
        if ((nums[index]-k < 0 || count[nums[index]-k] == 0)
            && (nums[index]+k >= count.length || count[nums[index]+k] == 0)) {
            count[nums[index]]++;
            answer += find(nums, k, count, index+1);
            count[nums[index]]--;
        }
        return answer;
    }
}