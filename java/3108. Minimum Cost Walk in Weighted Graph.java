class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1], edge[2]);
        }
        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int x = query[i][0];
            int y = query[i][1];
            if (x == y) {
                answer[i] = 0;
            } else if (uf.find(x) != uf.find(y)) {
                answer[i] = -1;
            } else {
                answer[i] = uf.findWeight(x);
                answer[i] = answer[i] == 2147483647 ? 0 : answer[i];
            }
        }
        return answer;
    }
}

class UnionFind {
    private int[] parent;
    private int[] bitwiseAnd;
    private static final int ONES = Integer.parseInt("1111111111111111111111111111111", 2);
  
    UnionFind(int n) {
        parent = new int[n];
        bitwiseAnd = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            bitwiseAnd[i] = ONES;
        }
    }

    int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    int findWeight(int x) {
        return bitwiseAnd[find(x)];
    }

    void union(int x, int y, int weight) {
        int rootX = find(x);
        int rootY = find(y);
        if (x < y) {
            parent[rootY] = rootX;
            bitwiseAnd[rootX] &= bitwiseAnd[rootY];
            bitwiseAnd[rootX] &= weight;
        } else {
            parent[rootX] = rootY;
            bitwiseAnd[rootY] &= bitwiseAnd[rootX];
            bitwiseAnd[rootY] &= weight;
        }
    }
}