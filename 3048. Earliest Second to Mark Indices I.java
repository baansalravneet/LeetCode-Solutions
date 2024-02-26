class Solution {
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int m = changeIndices.length;
        int left = 0;
        int right = m-1;
        int answer = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canMake(nums, changeIndices, mid, sum)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer == -1 ? -1 : answer+1;
    }
    private boolean canMake(int[] nums, int[] changeIndices, int li, long sum) {
        int[] lastIndex = new int[nums.length+1];
        for (int i = 0; i <= li; i++) {
            lastIndex[changeIndices[i]] = i+1;
        }
        int marked = 0, operations = 0;
        for (int i = 0; i <= li; i++) {
            if (lastIndex[changeIndices[i]] == i+1) {
                if (nums[changeIndices[i]-1] > operations) return false;
                marked++;
                operations -= nums[changeIndices[i]-1];
            } else {
                operations++;
            }
        }
        return marked == nums.length;
    }
}


