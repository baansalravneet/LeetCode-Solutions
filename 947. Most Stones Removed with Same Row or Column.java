class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (stones[i][0] == stones[j][0]
                        || stones[i][1] == stones[j][1]) uf.union(i, j);
            }
        }
        return n - uf.count;
    }
}

class UnionFind {
    int[] parent;
    int count;
    UnionFind(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    void union(int i, int j) {
        int parentI = find(i);
        int parentJ = find(j);
        if (parentI == parentJ) return;
        if (parentI < parentJ) {
            parent[parentJ] = parentI;
        } else {
            parent[parentI] = parentJ;
        }
        count--;
    }
    int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}


