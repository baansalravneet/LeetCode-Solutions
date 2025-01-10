class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] amount = new int[n+1];
        for (int[] q : shifts) {
            int start = q[0], end = q[1]+1, dir = q[2];
            if (dir == 1) {
                amount[start] += 1;
                amount[end] -= 1;
            } else {
                amount[start] -= 1;
                amount[end] += 1;
            }
        }
        char[] arr = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (sum + amount[i]) % 26;
            arr[i] = (char)((arr[i] - 'a' + sum + 26) % 26 + 'a');
        }
        return new String(arr);
    }
}

