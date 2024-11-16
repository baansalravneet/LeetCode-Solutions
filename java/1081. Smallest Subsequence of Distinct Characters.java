class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i)-'a'] = i;
        }
        Deque<Integer> stack = new ArrayDeque<>();
        boolean[] seen = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            int current = s.charAt(i)-'a';
            if (seen[current]) continue;
            while (!stack.isEmpty() && stack.peekLast() > current && lastIndex[stack.peekLast()] > i) {
                seen[stack.pollLast()] = false;
            }
            seen[current] = true;
            stack.addLast(current);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char)(stack.pollFirst()+'a'));
        }
        return sb.toString();
    }
}
