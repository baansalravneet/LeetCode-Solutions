class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> wordGroups = new HashMap<>();
        for (String word : wordList) {
            StringBuilder sb = new StringBuilder(word);
            for (int i = 0; i < sb.length(); i++) {
                char c = sb.charAt(i);
                sb.setCharAt(i, '*');
                wordGroups.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(word);
                sb.setCharAt(i, c);
            }
        }
        Deque<String> bfsQ = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        bfsQ.addLast(beginWord);
        int steps = 1;
        while (!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            while (size-- > 0) {
                String word = bfsQ.pollFirst();
                if (word.equals(endWord)) {
                    return steps;
                }
                if (visited.contains(word)) {
                    continue;
                }
                visited.add(word);
                StringBuilder sb = new StringBuilder(word);
                for (int i = 0; i < sb.length(); i++) {
                    char c = sb.charAt(i);
                    sb.setCharAt(i, '*');
                    if (!wordGroups.containsKey(sb.toString())) {
                        sb.setCharAt(i, c);
                        continue;
                    }
                    for (String next : wordGroups.get(sb.toString())) {
                        if (next.equals(word) || visited.contains(next)) {
                            continue;
                        }
                        bfsQ.addLast(next);
                    }
                    sb.setCharAt(i, c);
                }
            }
            steps++;
        }
        return 0;
    }
}

