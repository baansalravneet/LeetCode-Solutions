class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int answer = 0;
        int diagonal = 0;
        for (int[] d : dimensions) {
            int currDia = d[0]*d[0] + d[1]*d[1];
            if (currDia > diagonal) {
                answer = d[0] * d[1];
                diagonal = currDia;
            } else if (currDia == diagonal) {
                answer = Math.max(answer, d[0] * d[1]);
            }
        }
        return answer;
    }
}
