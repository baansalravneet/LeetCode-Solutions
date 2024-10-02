class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> encode = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+') {
                encode.add(-1);
                continue;
            }
            if (c == '-') {
                encode.add(-2);
                continue;
            }
            if (c == '*') {
                encode.add(-3);
                continue;
            }
            int num = 0;
            while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                num = num * 10 + expression.charAt(i) - '0';
                i++;
            }
            encode.add(num);
            i--;
        }
        return helper(encode, 0, encode.size()-1);
    }
    private List<Integer> helper(List<Integer> encode, int left, int right) {
        if (left > right) return new ArrayList<>();
        if (left == right) return List.of(encode.get(left));
        List<Integer> answer = new ArrayList<>();
        for (int i = left + 1; i <= right - 1; i += 2) {
            int sign = encode.get(i);
            List<Integer> leftResult = helper(encode, left, i-1);
            List<Integer> rightResult = helper(encode, i+1, right);
            for (int x : leftResult) {
                for (int y : rightResult) {
                    if (sign == -1) answer.add(x + y);
                    else if (sign == -2) answer.add(x - y);
                    else if (sign == -3) answer.add(x * y);
                }
            }
        }
        return answer;
    }
}