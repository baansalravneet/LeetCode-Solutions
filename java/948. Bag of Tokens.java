class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int answer = 0;
        int score = 0;
        int left = 0;
        int right = tokens.length-1;
        while (left <= right) {
            if (tokens[left] <= power) {
                power -= tokens[left++];
                score++;
                answer = Math.max(score, answer);
            } else {
                if (score == 0) return 0;
                power += tokens[right--];
                score--;
            }
        }
        return answer;
    }
}
