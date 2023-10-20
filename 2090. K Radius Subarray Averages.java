class Solution {
    public int[] getAverages(int[] nums, int k) {
        int number = (2*k) + 1;
        long sum = 0;
        for (int i = 0; i < nums.length && i < number; i++) {
            sum += nums[i];
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        int left = 0;
        int index = k;
        int right = number;
        while (right < nums.length) {
            result[index++] = (int)(sum / number);
            sum += nums[right++];
            sum -= nums[left++];
        }
        if (index < result.length && right == nums.length) {
            result[index] = (int)(sum / number);
        }
        return result;
    }
}
