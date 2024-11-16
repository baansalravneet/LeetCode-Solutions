class Solution {
    public int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> index = new HashMap<>();
        for (int i = 0; i < ring.length(); i++) {
            index.computeIfAbsent(ring.charAt(i), k -> new ArrayList<>()).add(i);
        }
        Integer[][] cache = new Integer[key.length()][ring.length()];
        return helper(ring.length(), key, 0, 0, index, cache);
    }
    private int helper(int n, String key, int i, int currIndex, Map<Character, List<Integer>> index, Integer[][] cache) {
        if (i == key.length()) {
            return 0;
        }
        if (cache[i][currIndex] != null) {
            return cache[i][currIndex];
        }
        int answer = Integer.MAX_VALUE;
        for (int next : index.get(key.charAt(i))) {
            int distance = Math.min(Math.abs(currIndex-next), n-Math.abs(currIndex-next));
            answer = Math.min(answer, distance + helper(n, key, i+1, next, index, cache));
        }
        return cache[i][currIndex] = answer+1;
    }
}
