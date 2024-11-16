class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(helper(answerKey, k, 'T'), helper(answerKey, k, 'F'));
    }
    private int helper(String answerKey, int k, char charToCount) {
        int left = 0;
        int count = 0;
        int answer = 0;
        for (int right = 0; right < answerKey.length(); right++) {
            if (answerKey.charAt(right) == charToCount) {
                count++;
            }
            while (count > k) {
                if (answerKey.charAt(left) == charToCount) count--;
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}
