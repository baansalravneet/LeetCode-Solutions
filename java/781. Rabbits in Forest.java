class Solution {
    public int numRabbits(int[] answers) {
        int[] freq = new int[1001];
        for (int i : answers) {
            freq[i]++;
        }
        int answer = 0;
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] == 0) continue;
            answer += (int)Math.ceil((double)(freq[i])/(double)(i+1)) * (i+1);
        }
        return answer+freq[0];
    }
}
