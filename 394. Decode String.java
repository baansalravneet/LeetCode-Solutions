class Solution {
    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int count = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    count *= 10;
                    count += s.charAt(i) - '0';
                    i++;
                }
                stack.addLast(String.valueOf(count));
                continue;
            }
            if (c >= 'a' && c <= 'z') {
                stack.addLast(String.valueOf(c));
                i++;
                continue;
            }
            if (c == ']') {
                StringBuilder sb = new StringBuilder();
                while (!stack.isEmpty() && !Character.isDigit(stack.peekLast().charAt(0))) {
                    sb.insert(0, stack.pollLast());                    
                }
                int count = Integer.parseInt(stack.pollLast());
                StringBuilder result = new StringBuilder();
                while (count-- > 0) {
                    result.append(sb);
                }
                stack.addLast(result.toString());
                i++;
                continue;
            }
            i++;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pollFirst());
        }
        return result.toString();
    }
}
