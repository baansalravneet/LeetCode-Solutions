class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                count--;
            } else {
                count++;
            }
            if (count < 0) {
                answer++;
                count = 0;
            }
        }
        return answer + count;
    }
}
