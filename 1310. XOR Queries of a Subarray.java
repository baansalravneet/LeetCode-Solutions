class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i-1] ^ arr[i];
        }
        int[] answer = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int left = q[0];
            int right = q[1];
            if (left == 0) answer[i++] = prefix[right];
            else answer[i++] = prefix[right] ^ prefix[left-1];
        }
        return answer;
    }
}
