class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        permute(nums, result, 0);
        return result;
    }
    private void permute(int[] nums, List<List<Integer>> result, int index) {
        if (index == nums.length-1) {
            result.add(Arrays.stream(nums).boxed().toList());
            return;
        }
        permute(nums, result, index+1);
        Set<Integer> set = new HashSet<>();
        for (int i = index+1; i < nums.length; i++) {
            if (set.contains(nums[i]) || nums[i] == nums[index]) continue;
            set.add(nums[i]);
            swap(nums, i, index);
            permute(nums, result, index+1);
            swap(nums, i, index);
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}


