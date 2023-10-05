class Solution {
    public void nextPermutation(int[] nums) {
        int i = findFirstDescent(nums);
        if (i == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        int j = findNextGreater(nums, i);
        swap(nums, i, j);
        reverse(nums, i+1, nums.length-1);
    }
    private int findNextGreater(int[] nums, int i) {
        int number = nums[i];
        int answer = -1;
        int nextGreater = Integer.MAX_VALUE;
        i++;
        while (i < nums.length) {
            if (nums[i] > number) {
                if (nextGreater >= nums[i]) {
                    answer = i;
                    nextGreater = nums[i];
                }
            }
            i++;
        }
        return answer;
    }
    private int findFirstDescent(int[] nums) {
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) return i;
        }
        return -1;
    }
    private void reverse(int[] nums, int start, int end) {
        if (start >= end) return;
        swap(nums, start, end);
        reverse(nums, start+1, end-1);
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
