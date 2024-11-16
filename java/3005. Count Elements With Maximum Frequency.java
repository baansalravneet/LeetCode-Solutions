class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxFreq = 0;
        int[] freq = new int[101];
        for (int i : nums) {
            freq[i]++;
            maxFreq = Math.max(maxFreq, freq[i]);
        }
        int answer = 0;
        for (int i : freq) {
            if (i == maxFreq) answer += i;
        }
        return answer;
    }
}
