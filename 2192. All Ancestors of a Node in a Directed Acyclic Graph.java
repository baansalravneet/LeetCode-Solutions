class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            result.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        for (int i = 0; i < n; i++) {
            dfs(i, i, graph, result);
        }
        return result;
    }
    private void dfs(int current, int ancestor, List<Integer>[] graph, List<List<Integer>> result) {
        for (int child : graph[current]) {
            if (result.get(child).size() == 0 || result.get(child).get(result.get(child).size()-1) != ancestor) {
                result.get(child).add(ancestor);
                dfs(child, ancestor, graph, result);
            }
        }
    }
}

