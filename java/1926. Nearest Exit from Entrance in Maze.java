class Solution {
    private static final int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int steps = 0;
        Deque<int[]> q = new LinkedList<>();
        q.addLast(new int[] {entrance[0], entrance[1]});
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] current = q.pollFirst();
                if (visited[current[0]][current[1]]) continue;
                visited[current[0]][current[1]] = true;
                for (int[] d : directions) {
                    int x = current[0] + d[0];
                    int y = current[1] + d[1];
                    if (x < 0 || x >= maze.length) continue;
                    if (y < 0 || y >= maze[0].length) continue;
                    if (maze[x][y] == '+') continue;
                    if (x == entrance[0] && y == entrance[1]) continue;
                    if (x == 0 || x == maze.length-1) return steps+1;
                    if (y == 0 || y == maze[0].length-1) return steps+1;
                    if (visited[x][y]) continue;
                    q.addLast(new int[] {x,y});
                }
            }
            steps++;
        }
        return -1;
    }
}