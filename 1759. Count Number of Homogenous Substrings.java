class Solution {
    private static final int MOD = 1_000_000_007;
    public int countHomogenous(String s) {
        long answer = 0;
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            int count = 0;
            while (index < s.length() && s.charAt(index) == c) {
                index++;
                count++;
            }
            answer += ((long)count * (count+1)) / 2;
            answer %= MOD;
        }
        return (int) answer;
    }
}
