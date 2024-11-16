class Solution {
    private static final int[][] directions = {
        {1,2}, {1,-2}, {2,1}, {2,-1},
        {-1,-2}, {-1,2}, {-2,1}, {-2,-1}
    };
    public int maxMoves(int kx, int ky, int[][] positions) {
        int[][] moves = getMoves(kx, ky, positions);
        return helper(0, moves, 1, 1, new HashMap<>());
    }
    private int helper(int current, int[][] moves, int isAlice, int captured, Map<Long, Integer> cache) {
        if (Integer.bitCount(captured) == moves.length) return 0;
        long key = ((long)current << 33) | ((long)captured << 1) | isAlice;
        if (cache.containsKey(key)) return cache.get(key);
        int answer;
        if (isAlice == 1) answer = Integer.MIN_VALUE;
        else answer = Integer.MAX_VALUE;
        for (int i = 0; i < moves.length; i++) {
            if (i == current) continue;
            if ((captured & (1 << i)) != 0) continue;
            if (isAlice == 1) answer = Math.max(answer, moves[current][i] + helper(i, moves, 1-isAlice, captured | (1 << i), cache));
            else answer = Math.min(answer, moves[current][i] + helper(i, moves, 1-isAlice, captured | (1 << i), cache));
        }
        cache.put(key, answer);
        return answer;
    }
    private int[][] getMoves(int kx, int ky, int[][] positions) {
        int[][] result = new int[positions.length+1][positions.length+1];
        for (int i = 0; i < positions.length; i++) {
            int moves = shortest(kx, ky, positions[i][0], positions[i][1]);
            result[0][i+1] = moves;
            result[i+1][0] = moves;
        }
        for (int i = 0; i < positions.length; i++) {
            for (int j = i+1; j < positions.length; j++) {
                int moves = shortest(positions[i][0], positions[i][1], positions[j][0], positions[j][1]);
                result[i+1][j+1] = moves;
                result[j+1][i+1] = moves;
            }
        }
        return result;
    }
    private int shortest(int sx, int sy, int tx, int ty) {
        Deque<Pair<Integer, Integer>> q = new ArrayDeque<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        q.addLast(new Pair(sx, sy));
        int moves = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair<Integer, Integer> current = q.pollFirst();
                if (current.getKey() == tx && current.getValue() == ty) return moves;
                if (visited.contains(current)) continue;
                visited.add(current);
                for (int[] d : directions) {
                    int nx = current.getKey() + d[0];
                    int ny = current.getValue() + d[1];
                    if (nx < 0 || nx >= 50 || ny < 0 || ny >= 50) continue;
                    Pair<Integer, Integer> next = new Pair(nx, ny);
                    if (visited.contains(next)) continue;
                    q.addLast(next);
                }
            }
            moves++;
        }
        return -1;
    }
}

