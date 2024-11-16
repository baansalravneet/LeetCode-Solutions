class Solution {
    public boolean parseBoolExpr(String expression) {
        Map<Integer, Integer> pairs = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                stack.addLast(i);
            } else if (expression.charAt(i) == ')') {
                pairs.put(stack.pollLast(), i);
            }
        }
        return helper(expression, 0, expression.length()-1, pairs);
    }
    private boolean helper(String s, int left, int right, Map<Integer, Integer> pairs) {
        boolean answer;
        char c = s.charAt(left);
        if (c == '(') {
            answer = helper(s, left+1, pairs.get(left)-1, pairs);
        } else if (c == '!') {
            answer = !helper(s, left+2, pairs.get(left+1)-1, pairs);
        } else if (c == '&') {
            answer = calAnd(s, left+2, pairs.get(left+1)-1, pairs);
        } else if (c == '|') {
            answer = calOr(s, left+2, pairs.get(left+1)-1, pairs);
        } else {
            answer = c == 't';
        }
        return answer;
    }
    private boolean calAnd(String s, int left, int right, Map<Integer, Integer> pairs) {
        boolean answer = true;
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == '&') {
                answer &= calAnd(s, i+2, pairs.get(i+1)-1, pairs);
                i = pairs.get(i+1)+1;
            } else if (s.charAt(i) == '|') {
                answer &= calOr(s, i+2, pairs.get(i+1)-1, pairs);
                i = pairs.get(i+1)+1;
            } else if (s.charAt(i) == '!') {
                answer &= !helper(s, i+2, pairs.get(i+1)-1, pairs);
                i = pairs.get(i+1)+1;
            } else {
                answer &= s.charAt(i) == 't';
                i++;
            }
        }
        return answer;
    }
    private boolean calOr(String s, int left, int right, Map<Integer, Integer> pairs) {
        boolean answer = false;
        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == '&') {
                answer |= calAnd(s, i+2, pairs.get(i+1)-1, pairs);
                i = pairs.get(i+1)+1;
            } else if (s.charAt(i) == '|') {
                answer |= calOr(s, i+2, pairs.get(i+1)-1, pairs);
                i = pairs.get(i+1)+1;
            } else if (s.charAt(i) == '!') {
                answer |= !helper(s, i+2, pairs.get(i+1)-1, pairs);
                i = pairs.get(i+1)+1;
            } else {
                answer |= s.charAt(i) == 't';
                i++;
            }
        }
        return answer;
    }
}
