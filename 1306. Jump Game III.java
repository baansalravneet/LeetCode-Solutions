class Solution {
    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start, new boolean[arr.length]);
    }
    private boolean dfs(int[] arr, int current, boolean[] visited) {
        if (current < 0 || current >= arr.length) return false;
        if (arr[current] == 0) return true;
        if (visited[current]) return false;
        visited[current] = true;
        boolean answer = dfs(arr, current + arr[current], visited);
        if (answer) return answer;
        answer = dfs(arr, current - arr[current], visited);
        return answer;
    }
}
