class Solution {
    public int titleToNumber(String s) {
        int answer = 0;
        for (char c : s.toCharArray()) {
            answer *= 26;
            answer += c - 'A' + 1;
        }
        return answer;
    }
}
