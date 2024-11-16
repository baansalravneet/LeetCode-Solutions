class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int j = 0;
        while (j <= k && j < nums.length) {
            set.add(nums[j]);
            j++;
        }
        if (set.size() != j) return true;
        int i = 0;
        while (j < nums.length) {
            set.remove(nums[i]);
            set.add(nums[j]);
            if (set.size() <= k) return true;
            i++;
            j++;
        }
        return false;
    }
}
