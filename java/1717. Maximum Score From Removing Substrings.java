class Solution {
    public int maximumGain(String s, int x, int y) {
        String highPriority = x < y ? "ba" : "ab";
        String lowPriority = y < x ? "ba" : "ab";
        String firstPass = remove(s, highPriority);
        int answer = Math.max(x,y) * (s.length() - firstPass.length()) / 2;
        String secondPass = remove(firstPass, lowPriority);
        answer += Math.min(x,y) * (firstPass.length() - secondPass.length()) / 2;
        return answer;
    }
    private String remove(String s, String sub) {
        Deque<Character> stack = new ArrayDeque<>();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.addLast(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == sub.charAt(1) && stack.peekLast() == sub.charAt(0)) {
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
}