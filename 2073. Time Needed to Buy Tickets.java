class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int answer = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                if (tickets[i] <= tickets[k]) answer += tickets[i];
                else answer += tickets[k];
            } else {
                if (tickets[i] <= tickets[k] - 1) answer += tickets[i];
                else answer += tickets[k] - 1;
            }
        }
        return answer;
    }
}