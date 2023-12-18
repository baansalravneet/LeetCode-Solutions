class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < fact(nums.length); i++) {
            List<Integer> result = new ArrayList<>();
            for (int j : nums) {
                result.add(j);
            }
            answer.add(result);
            nextPermutation(nums);
        }
        return answer;
    }
    private void nextPermutation(int[] nums) {
        int firstDown = getFirstDown(nums);
        if (firstDown == nums.length) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        int nextGreaterIndex = findNext(nums, firstDown+1, nums.length-1, nums[firstDown]);
        swap(nums, nextGreaterIndex, firstDown);
        reverse(nums, firstDown+1, nums.length-1);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    private int findNext(int[] nums, int left, int right, int target) {
        int answer = -1;
        for (int i = left; i <= right; i++) {
            if (nums[i] > target && (answer == -1 || nums[answer] > nums[i])) {
                answer = i;
            }
        }
        return answer;
    }
    private int getFirstDown(int[] nums) {
        for (int i = nums.length-1; i >= 1; i--) {
            if (nums[i] > nums[i-1]) {
                return i-1;
            }
        }
        return nums.length;
    }
    private int fact(int i) {
        if (i == 1 || i == 0) {
            return 1;
        }
        return i * fact(i-1);
    }
}
