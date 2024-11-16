class Solution {
    public int getLucky(String s, int k) {
        int answer = 0;
        for (char c : s.toCharArray()) answer += getDigitSum(c-'a'+1);
        while (k-- > 1) answer = getDigitSum(answer);
        return answer;
    }
    private int getDigitSum(int i) {
        int answer = 0;
        while (i > 0) {
            answer += i % 10;
            i /= 10;
        }
        return answer;
    }
}

