class Solution {
    public long calculateScore(String s) {
        int n = s.length();
        Map<Character, Deque<Integer>> unmarked = new HashMap<>();
        boolean[] mark = new boolean[n];
        long answer = 0;
        for (int i = 0; i < n; i++) {
            char a = s.charAt(i);
            char b = (char)(25 - a + 'a' + 'a');
            Deque<Integer> indexes = unmarked.get(b);
            if (indexes != null && !indexes.isEmpty()) {
                int index = indexes.pollLast();
                answer += (long)i - index;
            } else {
                unmarked.computeIfAbsent(s.charAt(i), k -> new LinkedList<>()).addLast(i);
            }
        }
        return answer;
    }
}

