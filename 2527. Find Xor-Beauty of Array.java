class Solution {
    public int xorBeauty(int[] nums) {
        int answer = 0;
        for (int i : nums) answer ^= i;
        return answer;
    }
}
