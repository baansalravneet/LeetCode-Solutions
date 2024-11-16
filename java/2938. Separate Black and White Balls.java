class Solution {
    public long minimumSteps(String s) {
        long answer = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)== '0') {
                answer += i - index;
                index++;
            }
        }
        return answer;
    }
}

