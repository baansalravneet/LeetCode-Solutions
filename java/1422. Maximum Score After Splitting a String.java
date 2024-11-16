class Solution {
    public int maxScore(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                sum++;
            }
        }
        int score = -1;
        int left = 0;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '0') {
                left++;
            } else {
                sum--;
            }
            score = Math.max(score, left+sum);
        }
        return score;
    }
}
