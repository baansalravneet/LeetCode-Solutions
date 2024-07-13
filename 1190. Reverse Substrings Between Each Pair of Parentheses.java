class Solution {
    public String reverseParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> tele = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addLast(i);
            } else if (c == ')') {
                int prev = stack.pollLast();
                tele.put(i, prev);
                tele.put(prev, i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (
            int i = 0, direction = 1;
            i < s.length();
            i += direction
        ) {
            char c = s.charAt(i);
            if (c != '(' && c != ')') {
                sb.append(c);
                continue;
            }
            i = tele.get(i);
            direction = -direction;
        }
        return sb.toString();
    }
}