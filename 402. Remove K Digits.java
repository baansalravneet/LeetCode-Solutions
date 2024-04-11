class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && answer.length() > 0 && answer.charAt(answer.length()-1) > num.charAt(i)) {
                answer.deleteCharAt(answer.length()-1);
                k--;
            }
            answer.append(num.charAt(i));
        }
        while (answer.length() > 0 && k != 0) {
            answer.deleteCharAt(answer.length()-1);
            k--;
        }
        while (answer.length() > 0 && answer.charAt(0) == '0') {
            answer.deleteCharAt(0);
        }
        return answer.length() == 0 ? "0" : answer.toString();
    }
}