class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        long answer = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            if (right < k-1) {
                sum += (long)nums[right];
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                continue;
            }
            sum += (long)nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            if (map.size() == k) {
                answer = Math.max(answer, sum);
            }
            sum -= (long)nums[left];
            if (map.get(nums[left]) == 1) map.remove(nums[left]);
            else map.put(nums[left], map.get(nums[left]) - 1);
            left++;
        }
        return answer;
    }
}
