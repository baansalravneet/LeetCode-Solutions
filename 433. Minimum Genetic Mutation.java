class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> visited = new HashSet<>();
        Deque<String> bfsQueue = new ArrayDeque<>();
        bfsQueue.addLast(startGene);
        visited.add(startGene);
        int count = 0;
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            while (size-- > 0) {
                String current = bfsQueue.pollFirst();
                for (String i : getNext(current, bank)) {
                    if (visited.contains(i)) continue;
                    if (i.equals(endGene)) return count+1;
                    visited.add(i);
                    bfsQueue.addLast(i);
                }
            }
            count++;
        }
        return -1;
    }
    private List<String> getNext(String current, String[] bank) {
        List<String> result = new ArrayList<>();
        for (String i : bank) {
            if (mutations(current, i) == 1) result.add(i);
        }
        return result;
    }
    private int mutations(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) count++;
        }
        return count;
    }
}
