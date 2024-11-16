class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int i : nums) sum += encrypt(i);
        return sum;
    }
    private int encrypt(int i) {
        int maxDigit = 0;
        for (char c : String.valueOf(i).toCharArray()) maxDigit = Math.max(maxDigit, c - '0');
        int answer = 0;
        while (i > 0) {
            answer *= 10;
            answer += maxDigit;
            i /= 10;
        }
        return answer;
    }
}

