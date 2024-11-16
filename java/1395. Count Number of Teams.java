class Solution {
    public int numTeams(int[] rating) {
        int answer = 0;
        for (int i = 1; i < rating.length-1; i++) {
            int leftSmaller = 0;
            int leftGreater = 0;
            int rightSmaller = 0;
            int rightGreater = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) leftSmaller++;
                else leftGreater++;
            }
            for (int j = i+1; j < rating.length; j++) {
                if (rating[j] < rating[i]) rightSmaller++;
                else rightGreater++;
            }
            answer += leftSmaller * rightGreater;
            answer += leftGreater * rightSmaller;
        }
        return answer;
    }
}