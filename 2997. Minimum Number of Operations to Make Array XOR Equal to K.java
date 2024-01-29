class Solution {
    public int minOperations(int[] nums, int k) {
        int answer = 0;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int x : nums) count = count + (check(x, i) ? 1 : 0);
            answer = answer + (((count%2 != 0) ^ check(k, i)) ? 1 : 0);
        }
        return answer;
    }
    private boolean check(int i, int pos) {
        return (i&(1<<pos)) > 0;
    }
}
