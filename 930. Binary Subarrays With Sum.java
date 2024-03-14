class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> prefixCount = new HashMap<>();
        int sum = 0, count = 0;
        prefixCount.put(0, 1);
        for (int i : nums) {
            sum += i;
            count += prefixCount.getOrDefault(sum - goal, 0);
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
