class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        Map<int[], Integer> indexes = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            indexes.put(edges[i], i);
        }
        Arrays.sort(edges, (a,b) -> a[2] - b[2]);
        int minWeight = getWeight(n, edges, null, null);
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();
        for (int[] e : edges) {
            int skipWeight = getWeight(n, edges, e, null);
            if (skipWeight > minWeight) critical.add(indexes.get(e));
            else {
                int takeWeight = getWeight(n, edges, null, e);
                if (takeWeight == minWeight) {
                    pseudoCritical.add(indexes.get(e));
                }
            }
        }
        return List.of(critical, pseudoCritical);
    }
    private int getWeight(int n, int[][] edges, int[] skip, int[] pick) {
        UnionFind uf = new UnionFind(n);
        int weight = 0;
        if (pick != null) {
            uf.union(pick[0], pick[1]);
            weight += pick[2];
        }
        for (int[] e : edges) {
            if (e != skip && uf.union(e[0], e[1])) weight += e[2];
        }
        return uf.count == 1 ? weight : Integer.MAX_VALUE;
    }
}

class UnionFind {
    int[] parent;
    int count;
    UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = n;
    }
    boolean union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return false;
        parent[pa] = pb;
        count--;
        return true;
    }
    int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }
}
