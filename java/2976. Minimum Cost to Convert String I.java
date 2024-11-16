class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] costs = new int[26][26];
        for (int[] i : costs) Arrays.fill(i, Integer.MAX_VALUE);
        for (int i = 0; i < original.length; i++) {
            costs[original[i]-'a'][changed[i]-'a'] = Math.min(cost[i], costs[original[i]-'a'][changed[i]-'a']);
        }
        for (int i = 0; i < 26; i++) {
            costs[i][i] = 0;
        }
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                if (costs[i][k] == Integer.MAX_VALUE) continue;
                for (int j = 0; j < 26; j++) {
                    if (costs[k][j] == Integer.MAX_VALUE) continue;
                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                }
            }
        }
        long answer = 0;
        for (int i = 0; i < source.length(); i++) {
            if (costs[source.charAt(i)-'a'][target.charAt(i)-'a'] == Integer.MAX_VALUE) {
                return -1;
            }
            answer += costs[source.charAt(i)-'a'][target.charAt(i)-'a'];
        }
        return answer;
    }
}