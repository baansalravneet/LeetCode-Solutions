class Solution {
    public int scoreOfParentheses(String s) {
        int answer = 0;
        int depth = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else if (s.charAt(i-1) == '(') {
                answer += 1 * (int)Math.pow(2, depth);
                depth--;
            } else {
                depth--;
            }
        }
        return answer;
    }
}
