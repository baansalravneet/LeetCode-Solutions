class Solution {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int answer = 0;
        Integer[][] cache = new Integer[n][k];
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, find(n, k, i, 0, stayScore, travelScore, cache));
        }
        return answer;
    }
    private int find(int n, int k, int current, int day, int[][] stayScore, int[][] travelScore, Integer[][] cache) {
        if (day == k) return 0;
        if (cache[current][day] != null) return cache[current][day];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (i == current) {
                answer = Math.max(answer, stayScore[day][current] + find(n, k, current, day+1, stayScore, travelScore, cache));
            } else {
                answer = Math.max(answer, travelScore[current][i] + find(n, k, i, day+1, stayScore, travelScore, cache));
            }
        }
        return cache[current][day] = answer;
    }
}