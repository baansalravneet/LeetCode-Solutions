class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long answer = 0;
        for (int i = n-1; i >= 0 && k > 0; i--, k--) {
            answer += Math.max(happiness[i] - n + i + 1, 0);
        }
        return answer;
    }
}