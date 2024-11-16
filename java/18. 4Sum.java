class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                long sum = nums[i] + nums[j];
                long remaining = target - sum;
                int left = j+1;
                int right = nums.length-1;
                while (left < right) {
                    long currentSum = nums[left] + nums[right];
                    if (currentSum > remaining) {
                        right--;
                    } else if (currentSum < remaining) {
                        left++;
                    } else {
                        List<Integer> entry = List.of(nums[i], nums[j], nums[left], nums[right]);
                        answer.add(entry);
                        while (left < right && nums[left] == entry.get(2)) {
                            left++;
                        }
                        while (left < right && nums[right] == entry.get(3)) {
                            right--;
                        }
                    }
                }
                while (i < nums.length-1 && nums[i] == nums[i+1]) {
                    i++;
                }
                while (j < nums.length-1 && nums[j] = nums[j+1]) {
                    j++;
                }
            }
        }
        return answer;
    }
}
