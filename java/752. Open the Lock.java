class Solution {
    public int openLock(String[] deadends, String target) {
        int answer = 0;
        Deque<String> bfsQ = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        for (String s : deadends) {
            visited.add(s);
        }
        bfsQ.addLast("0000");
        while (!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            while (size-- > 0) {
                String current = bfsQ.pollFirst();
                if (target.equals(current)) return answer;
                if (visited.contains(current)) continue;
                visited.add(current);
                for (String next : getNext(new StringBuilder(current))) {
                    if (visited.contains(next)) continue;
                    bfsQ.addLast(next);
                }
            }
            answer++;
        }
        return -1;
    }
    private List<String> getNext(StringBuilder sb) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            char current = sb.charAt(i);
            char previous = (char)((int)current - 1);
            if (!Character.isDigit(previous)) {
                previous += 10;
            }
            char next = (char)((int)current + 1);
            if (!Character.isDigit(next)) {
                next -= 10;
            }
            sb.setCharAt(i, previous);
            answer.add(sb.toString());
            sb.setCharAt(i, next);
            answer.add(sb.toString());
            sb.setCharAt(i, current);
        }
        return answer;
    }
}
