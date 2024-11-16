class Solution {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> set1 = getSet(nums1);
        Set<Integer> set2 = getSet(nums2);
        int n = nums1.length/2;
        Set<Integer> finalSet1 = getFinalSet(set1, set2, n);
        Set<Integer> finalSet2 = getFinalSet(set2, finalSet1, n);
        if (finalSet1.size() <= n && finalSet2.size() <= n) {
            finalSet1.addAll(finalSet2);
            return finalSet1.size();
        }
        finalSet1.addAll(finalSet2);
        if (finalSet1.size() >= 2*n) return 2*n;
        return finalSet1.size();
    }
    private Set<Integer> getFinalSet(Set<Integer> set1, Set<Integer> set2, int n) {
        if (set1.size() <= n) return set1;
        Set<Integer> finalSet = new HashSet<>();
        for (int i : set1) {
            if (finalSet.size() == n) break;
            if (!set2.contains(i)) finalSet.add(i);
        }
        for (int i : set1) {
            if (finalSet.size() == n) break;
            if (set2.contains(i)) finalSet.add(i);
        }
        return finalSet;
    }
    private Set<Integer> getSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);
        int count = nums.length/2;
        for (int i = 0; i < nums.length; ) {
            int rep = nums[i];
            set.add(rep);
            i++;
            while (i < nums.length && count > 0 && nums[i] == rep) {
                count--;
                i++;
            }
        }
        return set;
    }
}
