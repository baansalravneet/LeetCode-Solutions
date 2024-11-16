class Solution {
    public int maximumLength(int[] nums, int k) {
        int answer = 2;
        for (int i = 0; i < k; i++) {
            int[] freq = new int[k];
            int count = 0;
            for (int v : nums) {
                v %= k;
                freq[v] = freq[(i-v+k)%k]+1;
                count = Math.max(count, freq[v]);
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}