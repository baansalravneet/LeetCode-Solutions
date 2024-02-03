class Solution {
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestPathAllKeys(String[] grid) {
        Deque<int[]> bfsQ = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        bfsQ.addLast(getStartState(grid));
        int count = 0;
        while (!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            while (size-- > 0) {
                int[] current = bfsQ.pollFirst();
                int visitedState = getVisitedState(current);
                if (visited.contains(visitedState)) {
                    continue;
                }
                visited.add(visitedState);
                if (isDone(current)) return count;
                for (int[] state : getNextStates(grid, current)) {
                    if (visited.contains(getVisitedState(state))) continue;
                    bfsQ.addLast(state);
                }
            }
            count++;
        }
        return -1;
    }
    private int getVisitedState(int[] state) {
        int keyState = 0;
        for (int i = 2; i < state.length; i++) {
            keyState = (keyState << 1) | state[i];
        }
        int positionState = 30*state[0] + state[1];
        return (keyState << 10) | positionState;
    }
    private List<int[]> getNextStates(String[] grid, int[] current) {
        List<int[]> result = new ArrayList<>();
        for (int[] d : directions) {
            int nx = current[0] + d[0];
            int ny = current[1] + d[1];
            if (nx < 0 || nx >= grid.length) continue;
            if (ny < 0 || ny >= grid[0].length()) continue;
            char c = grid[nx].charAt(ny);
            if (c == '#') continue;
            int[] nextState = {nx, ny, current[2], current[3], current[4], current[5], current[6], current[7]};
            if (c >= 'A' && c <= 'Z') {
                if (current[c - 'A' + 2] == 1) continue;
            }
            if (c >= 'a' && c <= 'z') {
                nextState[c-'a'+2] = 0;
            }
            result.add(nextState);
        }
        return result;
    }
    private boolean isDone(int[] state) {
        for (int i = 2; i < state.length; i++) {
            if (state[i] == 1) return false;
        }
        return true;
    }
    private int[] getStartState(String[] grid) {
        int[] result = new int[8];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    result[0] = i;
                    result[1] = j;
                }
                else if (c >= 'a' && c <= 'z') {
                    int keyNumber = c-'a'+2;
                    result[keyNumber] = 1;
                }
            }
        }
        return result;
    }
}


// state = current position, which keys you collected already
// goal state = you collected all keys
// next action will depend on current position and if you are around a lock,
//     you need to know if you have the corresponding key or not
// visited dataset?
