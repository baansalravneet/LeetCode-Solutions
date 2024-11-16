class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> pairings = new ArrayDeque<>();
        Set<Integer> indexUnpaired = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                pairings.addLast(i);
            } else if (s.charAt(i) == ')') {
                if (pairings.isEmpty()) {
                    indexUnpaired.add(i);
                } else {
                    pairings.pollLast();
                }
            }
        }
        while (!pairings.isEmpty()) {
            indexUnpaired.add(pairings.pollLast());
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (indexUnpaired.contains(i)) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
