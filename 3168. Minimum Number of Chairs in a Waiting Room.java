class Solution {
    public int minimumChairs(String s) {
        int answer = 0;
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == 'E') count++;
            else count--;
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
