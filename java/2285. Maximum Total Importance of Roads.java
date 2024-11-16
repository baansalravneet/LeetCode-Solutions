class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long answer = 0, importance = 1;
        int[] degrees = new int[n];
        for (int[] road : roads) {
            degrees[road[0]]++;
            degrees[road[1]]++;
        }
        Arrays.sort(degrees);
        for (int d : degrees) answer += (importance++) * d;
        return answer;
    }
}
