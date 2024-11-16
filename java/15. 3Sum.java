class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length-1;
            while (left < right) {
                if (nums[left] + nums[right] == -nums[i]) {
                    answer.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                } else if (nums[left] + nums[right] > -nums[i]) right--;
                else left++;
            }
            while (i < nums.length-1 && nums[i] == nums[i+1]) i++;
        }
        return answer;
    }
}