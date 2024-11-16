class Solution {
    public int minFlips(int[][] mat) {
        Set<String> visited = new HashSet<>();
        Deque<Pair<int[][], String>> bfsQ = new ArrayDeque<>();
        String key = getKey(mat);
        bfsQ.addLast(new Pair(mat, key));
        int steps = 0;
        visited.add(key);
        while (!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            while (size-- > 0) {
                Pair<int[][], String> current = bfsQ.pollFirst();
                if (check(current.getKey())) {
                    return steps;
                }
                for (int[][] next : getNext(current.getKey())) {
                    String thisKey = getKey(next);
                    if (visited.contains(thisKey)) continue;
                    visited.add(thisKey);
                    bfsQ.addLast(new Pair(next, thisKey));
                }
            }
            steps++;
        }
        return -1;
    }
    private String getKey(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]);
            }
        }
        return sb.toString();
    }
    private boolean check(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                count += arr[i][j];
            }
        }
        return count == 0;
    }
    private List<int[][]> getNext(int[][] arr) {
        List<int[][]> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result.add(flip(arr, i, j));
            }
        }
        return result;
    }
    private int[][] flip(int[][] arr, int x, int y) {
        int[][] result = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (Math.abs(i-x) + Math.abs(j-y) <= 1) {
                    result[i][j] = 1-arr[i][j];
                } else {
                    result[i][j] = arr[i][j];
                }
            }
        }
        return result;
    }
}
