class Solution {
    public long minEnd(int n, int x) {
        if (n == 1) return x;
        String binaryN = Integer.toBinaryString(n-1);
        String binaryX = Integer.toBinaryString(x);
        StringBuilder answer = new StringBuilder();
        int pointer = binaryN.length() - 1;
        for (int i = binaryX.length() - 1; i >= 0; i--) {
            if (binaryX.charAt(i) == '1') {
                answer.append('1');
            } else {
                if (pointer >= 0) answer.append(binaryN.charAt(pointer--));
                else answer.append('0');
            }
        }
        while (pointer >= 0) answer.append(binaryN.charAt(pointer--));
        return Long.parseLong(answer.reverse().toString(), 2);
    }
}