class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, dir = 0;
        Set<String> obs = new HashSet<>();
        for (int[] o : obstacles) obs.add(o[0] + " " + o[1]);
        int answer = 0;
        for (int c : commands) {
            if (c == -1) dir = (dir+1)%4;
            else if (c == -2) dir = (dir+3)%4;
            else {
                while (c-- > 0) {
                    int nx = x, ny = y;
                    if (dir == 0) {
                        ny++;
                    } else if (dir == 1) {
                        nx++;
                    }else if (dir == 2) {
                        ny--;
                    } else {
                        nx--;
                    }
                    if (obs.contains(nx + " " + ny)) break;
                    x = nx;
                    y = ny;
                    answer = Math.max(answer, x*x + y*y);
                }
            }
        }
        return answer;
    }
}

