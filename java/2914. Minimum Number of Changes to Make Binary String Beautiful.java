class Solution {
    public int minChanges(String s) {
        boolean odd = false;
        int answer = 0;
        for (int i = 0; i < s.length(); ) {
            int count = 0;
            char c = s.charAt(i);
            while (i < s.length() && s.charAt(i) == c) {
                i++;
                count++;
            }
            if (odd) answer++;
            if (count%2 != 0) odd = !odd;
        }
        return answer;
    }
}