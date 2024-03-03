class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();
        a1.add(nums[0]);
        a2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (a1.get(a1.size()-1) > a2.get(a2.size()-1)) {
                a1.add(nums[i]);
            } else {
                a2.add(nums[i]);
            }
        }
        int[] result = new int[nums.length];
        int index = 0;
        for (int i : a1) result[index++] = i;
        for (int i : a2) result[index++] = i;
        return result;
    }
}
