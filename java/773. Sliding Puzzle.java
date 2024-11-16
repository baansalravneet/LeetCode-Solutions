class Solution {
    private static final String finalState = "123450";
    private static final int[][] moves = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
    public int slidingPuzzle(int[][] board) {
        String state = getState(board);
        int answer = 0;
        Set<String> visited = new HashSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.addLast(state);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                String current = q.pollFirst();
                if (current.equals(finalState)) {
                    return answer;
                }
                visited.add(current);
                for (String next : getNext(current)) {
                    if (!visited.contains(next)) {
                        q.addLast(next);
                    }
                }
            }
            answer++;
        }
        return -1;
    }
    private String[] getNext(String current) {
        int pos = -1;
        for (int i = 0; i < 6; i++) {
            if (current.charAt(i) == '0') {
                pos = i;
                break;
            }
        }
        String[] result = new String[moves[pos].length];
        for (int i = 0; i < moves[pos].length; i++) {
            result[i] = getSwapped(current, pos , moves[pos][i]);
        }
        return result;
    }
    private String getSwapped(String current, int i, int j) {
        StringBuilder sb = new StringBuilder(current);
        sb.setCharAt(i, current.charAt(j));
        sb.setCharAt(j, current.charAt(i));
        return sb.toString();
    }
    private String getState(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char)(board[i/3][i%3]+'0'));
        }
        return sb.toString();
    }
}
