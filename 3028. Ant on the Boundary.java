class Solution {
    public int returnToBoundaryCount(int[] nums) {
        int count = 0;
        int current = 0;
        for (int i : nums) {
            current += i;
            if (current == 0) count++;
        }
        return count;
    }
}

