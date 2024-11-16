class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int maxValue = -1;
        for (int i : costs) maxValue = Math.max(maxValue, i);
        int[] freq = new int[maxValue+1];
        for (int i : costs) freq[i]++;
        int answer = 0;
        for (int i = 0; i < freq.length; i++) {
            while (freq[i] > 0 && i <= coins) {
                answer++;
                freq[i]--;
                coins -= i;
            }
        }
        return answer;
    }
}
