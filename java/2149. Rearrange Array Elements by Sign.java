class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int pos = 0;
        int neg = 1;
        for (int i : nums) {
            if (i < 0) {
                result[neg] = i;
                neg += 2;
            } else {
                result[pos] = i;
                pos += 2;
            }
        }
        return result;
    }
}

