class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] freq = new int[32];
        int answer = Integer.MAX_VALUE, left = 0;
        for (int right = 0; right < nums.length; right++) {
            add(freq, nums[right]);
            while (get(freq) >= k && left <= right) {
                if (answer > right - left + 1) {
                    answer = right - left + 1;
                }
                remove(freq, nums[left]);
                left++;
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    private void remove(int[] freq, int num) {
        for (int i = 0; i < 32; i++) {
            if (num % 2 == 1) freq[i] -= 1;
            num /= 2;
        }
    }
    private void add(int[] freq, int num) {
        for (int i = 0; i < 32; i++) {
            if (num % 2 == 1) freq[i] += 1;
            num /= 2;
        }
    }
    private int get(int[] freq) {
        int answer = 0;
        for (int i = freq.length-1; i >= 0; i--) {
            answer *= 2;
            if (freq[i] > 0) {
                answer += 1;
            }
        }
        return answer;
    }
}