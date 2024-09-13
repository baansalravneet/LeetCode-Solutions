class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        int[] xorpre = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            xorpre[i+1] = xorpre[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            answer[i] = xorpre[queries[i][1]+1] ^ xorpre[queries[i][0]];
        }
        return answer;
    }
}