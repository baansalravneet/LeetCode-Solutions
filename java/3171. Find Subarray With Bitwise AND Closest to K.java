class Solution {
    public int minimumDifference(int[] nums, int k) {
        int[] bitFreq = new int[32];
        int left = 0;
        int answer = Integer.MAX_VALUE;
        for (int i : nums) answer = Math.min(answer, Math.abs(i-k));
        for (int right = 0; right < nums.length; right++) {
            add(bitFreq, nums[right]);
            int num = getNumber(bitFreq, right-left+1);
            answer = Math.min(answer, Math.abs(num-k));
            while (left <= right && num < k) {
                remove(bitFreq, nums[left]);
                left++;
                num = getNumber(bitFreq, right-left+1);
                answer = Math.min(answer, Math.abs(num - k));
            }
        }
        return answer;
    }
    private int getNumber(int[] freq, int n) {
        int answer = 0;
        for (int i = 0; i < 32; i++) {
            if (freq[i] == n) {
                answer ^= (1 << i);
            }
        }
        return answer;
    }
    private void add(int[] freq, int n) {
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) > 0) {
                freq[i]++;
            }
        }
    }
    private void remove(int[] freq, int n) {
        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) > 0) {
                freq[i]--;
            }
        }
    }
}
