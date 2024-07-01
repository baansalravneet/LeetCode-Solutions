class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);
        int count = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                count += (alice.union(edge[1], edge[2]) | bob.union(edge[1], edge[2]));
            }
        }
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                count += alice.union(edge[1], edge[2]);
            }
            if (edge[0] == 2) {
                count += bob.union(edge[1], edge[2]);
            }
        }
        if (alice.canTraverse() && bob.canTraverse()) {
            return edges.length - count;
        }
        return -1;
    }
}

class UnionFind {
    private int[] parents;
    private int components;

    UnionFind(int n) {
        parents = new int[n+1];
        for (int i = 0; i <= n; i++) {
            parents[i] = i;
        }
        components = n;
    }

    int union(int a, int b) {
        int parentA = find(a), parentB = find(b);
        if (parentA == parentB) return 0;
        if (parentA < parentB) parents[parentB] = parentA;
        else parents[parentA] = parentB;
        components--;
        return 1;
    }

    int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    boolean canTraverse() {
        return components == 1;
    }
}
