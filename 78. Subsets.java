class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        populate(nums, result, 0, new ArrayList<>());
        return result;
    }
    private void populate(
        int[] nums,
        List<List<Integer>> result,
        int index,
        List<Integer> current
    ) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        populate(nums, result, index+1, current);
        current.add(nums[index]);
        populate(nums, result, index+1, current);
        current.remove(current.size()-1);
    }
}