class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int[] answer = new int[adjacentPairs.length+1];
        Map<Integer, List<Integer>> adj = getAdj(adjacentPairs);
        dfs(answer, 0, adj, findStart(adj), Integer.MIN_VALUE);
        return answer;
    }
    private int findStart(Map<Integer, List<Integer>> adj) {
        for (int i : adj.keySet()) {
            if (adj.get(i).size() == 1) return i;
        }
        return -1;
    }
    private void dfs(int[] answer, int index, Map<Integer, List<Integer>> adj, int current, int previous) {
        if (index == answer.length) return;
        answer[index] = current;
        List<Integer> neighbourhood = adj.get(current);
        for (int i : neighbourhood) {
            if (i != previous) {
                dfs(answer, index+1, adj, i, current);
            }
        }
    }
    private Map<Integer, List<Integer>> getAdj(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int[] i : adjacentPairs) {
            int source = i[0];
            int destination = i[1];
            result.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
            result.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
        }
        return result;
    }
}
