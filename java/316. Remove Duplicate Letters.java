class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i)-'a'] = i;
        }
        boolean[] seen = new boolean[26];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            int current = s.charAt(i) - 'a';
            if (seen[current]) continue;
            while (!stack.isEmpty() && stack.peekLast() > current && lastIndex[stack.peekLast()] > i) {
                seen[stack.pollLast()] = false;
            }
            stack.addLast(current);
            seen[current] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char)(stack.pollFirst()+'a'));
        }
        return sb.toString();
    }
}

