class Solution {
    public String makeGood(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.addLast(s.charAt(i));
                continue;
            }
            if (checkSame(stack.peekLast(), s.charAt(i))) {
                stack.pollLast();
            } else {
                stack.addLast(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        return sb.toString();
    }
    private boolean checkSame(char a, char b) {
        if (a <= 'Z' && a >= 'A') {
            return a-'A' == b-'a';
        }
        if (a <= 'z' && a >= 'a') {
            return a-'a' == b-'A';
        }
        return false;
    }
}
