class Solution {
    public int calculate(String s) {
        Map<Integer, Integer> bracketPairs = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.addLast(i);
            }
            if (c == ')') {
                bracketPairs.put(stack.pollLast(), i);
            }
        }
        return helper(s, 0, s.length() - 1, bracketPairs);
    }
    private int helper(String s, int start, int end, Map<Integer, Integer> bracketPairs) {
        int index = start;
        int answer = 0;
        boolean positive = true;
        while (index <= end) {
            char c = s.charAt(index);
            if (c == ' ') {
                index++;
                continue;
            }
            if (c == '(') {
                if (positive)
                    answer += helper(s, index+1, bracketPairs.get(index)-1, bracketPairs);
                else {
                    answer -= helper(s, index+1, bracketPairs.get(index)-1, bracketPairs);
                    positive = true;
                }
                index = bracketPairs.get(index) + 1;
                continue;
            }
            if (c == '+') {
                index++;
                continue;
            }
            if (c == '-') {
                positive = !positive;
                index++;
                continue;
            }
            int current = 0;
            while (index <= end && Character.isDigit(s.charAt(index))) {
                c = s.charAt(index);
                int number = c - '0';
                current = current * 10 + number;
                index++;
            }
            if (positive) {
                answer += current;
            } else {
                answer -= current;
                positive = true;
            }
        }
        return answer;
    }
}
