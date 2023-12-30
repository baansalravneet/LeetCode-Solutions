class Solution {

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        completeGroups(n, m, group);
        Map<Integer, List<Integer>> groupEdges = getGroupEdges(n, group, beforeItems);
        List<Integer> groupOrder = topoSort(groupEdges);
        if (groupOrder == null) return new int[0];
        Map<Integer, Integer> groupIndex = new HashMap<>();
        for (int i = 0; i < groupOrder.size(); i++) {
            groupIndex.put(groupOrder.get(i), i);
        }
        Map<Integer, List<Integer>> internalEdges = getInternalEdges(n, group, beforeItems);
        List<Integer> internalOrder = topoSort(internalEdges);
        if (internalOrder == null) return new int[0];
        Map<Integer, Integer> internalIndex = new HashMap<>();
        for (int i = 0; i < internalOrder.size(); i++) {
            internalIndex.put(internalOrder.get(i), i);
        }
        Integer[] result = new Integer[n];
        for (int i = 0; i < n; i++) {
            result[i] = i;
        }
        Arrays.sort(result, (a,b) -> {
            if (group[a] == group[b]) {
                return internalIndex.get(a) - internalIndex.get(b);
            }
            return groupIndex.get(group[a]) - groupIndex.get(group[b]);
        });
        int[] answer = new int[result.length];
        for (int i = 0; i < n;  i++) {
            answer[i] = result[i];
        }
        return answer;
    }

    private Map<Integer, List<Integer>> getInternalEdges(int n, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < n; i++) {
            result.put(i, new ArrayList<>());
        }
        for (int i = 0; i < beforeItems.size(); i++) {
            for (int d : beforeItems.get(i)) {
                if (group[i] != group[d]) continue;
                result.get(d).add(i);
            }
        }
        return result;
    }

    private void completeGroups(int n, int m, int[] group) {
        for (int i = 0; i < n; i++) {
            if (group[i] != -1) continue;
            group[i] = m++;
        }
    }

    private Map<Integer, List<Integer>> getGroupEdges(int n, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, List<Integer>> result = new HashMap<>();
        for (int i = 0; i < n; i++) {
            result.putIfAbsent(group[i], new ArrayList<>());
        }
        for (int i = 0; i < beforeItems.size(); i++) {
            for (int j : beforeItems.get(i)) {
                if (group[i] == group[j]) continue;
                result.get(group[j]).add(group[i]);
            }
        }
        return result;
    }

    private List<Integer> topoSort(Map<Integer, List<Integer>> edges) {
        Map<Integer, Integer> inDegrees = new HashMap<>();
        for (List<Integer> v : edges.values()) {
            for (int e : v) {
                inDegrees.put(e, inDegrees.getOrDefault(e, 0) + 1);
            }
        }
        Deque<Integer> bfsQueue = new ArrayDeque<>();
        for (Integer k : edges.keySet()) {
            if (!inDegrees.containsKey(k)) {
                bfsQueue.addLast(k);
            }
        }
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        while (!bfsQueue.isEmpty()) {
            int current = bfsQueue.pollFirst();
            visited.add(current);
            result.add(current);
            if (!edges.containsKey(current)) continue;
            for (int next : edges.get(current)) {
                if (visited.contains(next)) {
                    continue;
                }
                inDegrees.put(next, inDegrees.get(next)-1);
                if (inDegrees.get(next) == 0) {
                    bfsQueue.add(next);
                }
            }
        }
        return result.size() == edges.size() ? result : null;
    }
}