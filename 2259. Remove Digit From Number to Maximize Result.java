class Solution {
    public String removeDigit(String number, char digit) {
        String answer = "0".repeat(number.length());
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == digit) {
                String possible = number.substring(0, i) + number.substring(i+1, number.length());
                if (possible.compareTo(answer) > 0) answer = possible;
            }
        }
        return answer;
    }
}

