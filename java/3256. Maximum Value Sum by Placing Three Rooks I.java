class Solution {
    public long maximumValueSum(int[][] board) {
        int n = board.length, m = board[0].length;
        PriorityQueue<Position> pq = new PriorityQueue<>((a,b) -> a.value - b.value);
        Position[][] grid = new Position[n][3];
        for (int i = 0; i < n; i++) {
            pq.clear();
            for (int j = 0; j < m; j++) {
                pq.add(new Position(j, board[i][j]));
                if (pq.size() > 3) pq.poll();
            }
            grid[i][0] = pq.poll();
            grid[i][1] = pq.poll();
            grid[i][2] = pq.poll();
        }
        Set<Integer> selected = new TreeSet<>();
        Map<String, Long> cache = new HashMap<>();
        return helper(n, m, 0, grid, selected, cache);
    }
    private long helper(
            int n,
            int m,
            int row,
            Position[][] grid,
            Set<Integer> selected,
            Map<String, Long> cache) {
        if (selected.size() == 3) return 0;
        if (row >= n) return Long.MIN_VALUE;
        String key = getKey(row, selected);
        if (cache.containsKey(key)) return cache.get(key);

        long answer = helper(n, m, row+1, grid, selected, cache);
        for (Position p : grid[row]) {
            if (!selected.contains(p.colNumber)) {
                selected.add(p.colNumber);
                long temp = helper(n, m, row+1, grid, selected, cache);
                if (temp != Long.MIN_VALUE) answer = Math.max(answer, temp + p.value);
                selected.remove(p.colNumber);
            }
        }
        cache.put(key, answer);
        return answer;
    }
    private String getKey(int row, Set<Integer> selected) {
        StringBuilder sb = new StringBuilder(row + ",");
        for (int v : selected) {
            sb.append(v + ",");
        }
        return sb.toString();
    }
}

class Position {
    int colNumber;
    int value;
    Position(int colNumber, int value) {
        this.colNumber = colNumber;
        this.value = value;
    }
}

