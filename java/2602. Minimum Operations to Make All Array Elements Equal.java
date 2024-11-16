class Solution {
    public List<Long> minOperations(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        long total = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
            total += nums[i];
        }
        List<Long> answer = new ArrayList<>();
        for (int i : queries) {
            int index = findIndex(i, nums);
            System.out.println(index);
            if (index == -1) answer.add(total - (long)i*n);
            else answer.add(((long)i * (index+1)) - prefix[index] + (total - prefix[index]) - (long)i*(n-index-1));
        }
        return answer;
    }
    private int findIndex(int k, int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= k) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}
