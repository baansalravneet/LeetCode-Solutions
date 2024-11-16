class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] >= n+1) {
                nums[i] = Integer.MIN_VALUE;
            }
        }
        int index = 0;
        while (index < nums.length) {
            int currentIndex = index;
            int currentNumber = nums[index];
            while (true) {
                if (currentNumber == Integer.MAX_VALUE || currentNumber == Integer.MIN_VALUE) break;
                int nextIndex = currentNumber - 1;
                int nextNumber = nums[nextIndex];
                nums[nextIndex] = Integer.MAX_VALUE;
                currentIndex = nextIndex;
                currentNumber = nextNumber;
            }
            index++;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != Integer.MAX_VALUE) return i+1;
        }
        return n+1;
    }
}
