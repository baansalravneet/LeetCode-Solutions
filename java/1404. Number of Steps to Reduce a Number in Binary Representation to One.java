class Solution {
    public int numSteps(String s) {
        int answer = 0, carry = 0;
        for (int i = s.length()-1; i >= 1; i--) {
            if (s.charAt(i) == '1') {
                if (carry == 1) {
                    answer += 1;
                } else {
                    answer += 2;
                    carry += 1;
                }
            } else {
                if (carry == 1) {
                    answer += 2;
                } else {
                    answer += 1;
                }
            }
        }
        if (s.charAt(0) == '0') {
            if (carry == 0) {
                answer += 1;
            }
        } else {
            if (carry == 1) {
                answer += 1;
            }
        }
        return answer;
    }
}