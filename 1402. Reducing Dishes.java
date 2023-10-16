class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int answer = 0;
        int current = 0;
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            current += satisfaction[i];
            if (current < 0) {
                break;
            }
            answer += current;
        }
        return answer;
    }
}
