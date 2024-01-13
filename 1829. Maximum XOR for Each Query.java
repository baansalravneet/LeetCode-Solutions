class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int totalXor = 0;
        int magicNumber = Integer.parseInt("1".repeat(maximumBit), 2);
        for (int i : nums) totalXor ^= i;
        int[] result = new int[nums.length];
        for (int i = nums.length-1; i >= 0; i--) {
            result[result.length-1-i] = totalXor ^ magicNumber;
            totalXor ^= nums[i];
        }
        return result;
    }
}
