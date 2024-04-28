class Solution {
    public int medianOfUniquenessArray(int[] nums) {
        long total = ((long)nums.length * (nums.length+1))/2;
        int left = 1;
        int right = nums.length;
        int answer = 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            long count = check(nums, mid);
            if (count * 2 >= total) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    private long check(int[] nums, int mid) {
        long count = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int size = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (!freq.containsKey(nums[right]) || freq.get(nums[right]) == 0) size++;
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            while (size > mid) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) size--;
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}