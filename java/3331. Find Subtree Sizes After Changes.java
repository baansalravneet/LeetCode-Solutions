class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int child = i;
            int father = parent[i];
            tree.get(father).add(i);
        }
        int[] newParent = new int[n];
        dfsParents(tree, 0, newParent, parent, new HashMap<>(), s);
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            int child = i;
            int father = newParent[i];
            tree.get(father).add(i);
        }
        int[] result = new int[n];
        dfsSize(tree, 0, result);
        return result;

    }
    private int dfsSize(List<List<Integer>> tree, int current, int[] result) {
        int size = 1;
        for (int i : tree.get(current)) {
            size += dfsSize(tree, i, result);
        }
        return result[current] = size;
    }
    private void dfsParents(
        List<List<Integer>> tree,
        int current,
        int[] newParent,
        int[] parent,
        Map<Character, Integer> lastSeen,
        String s
    ) {
        char c = s.charAt(current);
        Integer previous = lastSeen.get(c);
        if (previous != null) {
            newParent[current] = previous;
        } else {
            newParent[current] = parent[current];
        }
        lastSeen.put(c, current);
        for (int i : tree.get(current)) {
            dfsParents(tree, i, newParent, parent, lastSeen, s);
        }
        lastSeen.put(c, previous);
    }
}