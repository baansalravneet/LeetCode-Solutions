class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int answer = Integer.MIN_VALUE, runningMax = values[values.length-1] - (values.length-1);
        for (int i = values.length-2; i >= 0; i--) {
            answer = Math.max(answer, values[i] + i + runningMax);
            runningMax = Math.max(values[i] - i, runningMax);
        }
        return answer;
    }
}

