class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }
    private int helper(int[] nums, int k) {
        if (k > nums.length || k == 0) return 0;
        Map<Integer, Integer> counts = new HashMap<>();
        int left = 0;
        int count = 0;
        for (int right = 0; right < nums.length; right++) {
            counts.put(nums[right], counts.getOrDefault(nums[right], 0) + 1);
            while (left < right && counts.size() > k) {
                counts.put(nums[left], counts.get(nums[left]) - 1);
                if (counts.get(nums[left]) == 0) counts.remove(nums[left]);
                left++;
            }
            count += right - left + 1;
        }
        System.out.println(count);
        return count;
    }
}
