class Solution {
    public int[] singleNumber(int[] nums) {
        int total = 0;
        for (int i : nums) total ^= i;
        int set = 0;
        for ( ; set <= 32; set++) {
            if ((total & (1 << set)) > 0) break;
        }
        int answer1 = 0;
        int answer2 = 0;
        for (int i : nums) {
            if ((i & (1 << set)) > 0) answer1 ^= i;
            else answer2 ^= i;
        }
        return new int[] {answer1, answer2};
    }
}
