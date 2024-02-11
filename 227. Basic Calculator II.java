class Solution {
    public int calculate(String s) {
        Deque<Integer> evals = new ArrayDeque<>();
        char operation = '+';
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                current = 10 * current + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length()-1) {
                if (operation == '+') {
                    evals.addLast(current);
                } else if (operation == '-') {
                    evals.addLast(-current);
                } else if (operation == '*') {
                    evals.addLast(evals.pollLast() * current);
                } else if (operation == '/') {
                    evals.addLast(evals.pollLast() / current);
                }
                operation = c;
                current = 0;
            }
        }
        int answer = 0;
        while (!evals.isEmpty()) {
            answer += evals.pollLast();
        }
        return answer;
    }
}
