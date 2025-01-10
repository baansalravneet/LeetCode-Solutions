class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = getDiameter(edges1);
        int d2 = getDiameter(edges2);
        return Math.max(d1, Math.max(d2, (d1+1)/2 + (d2+1)/2 + 1));
    }
    private int getDiameter(int[][] edges) {
        Map<Integer, List<Integer>> tree = getTree(edges);
        FarPoint fp = getFarPoint(tree, 0, -1);
        fp = getFarPoint(tree, fp.node, -1);
        return fp.distance;
    }
    private Map<Integer, List<Integer>> getTree(int[][] edges) {
        Map<Integer, List<Integer>> tree = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            tree.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            tree.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }
        return tree;
    }
    private FarPoint getFarPoint(Map<Integer, List<Integer>> tree, int node, int parent) {
        int farNode = 0;
        int farDistance = -1;
        for (int next : tree.get(node)) {
            if (next == parent) continue;
            FarPoint fp = getFarPoint(tree, next, node);
            if (fp.distance > farDistance) {
                farNode = fp.node;
                farDistance = fp.distance;
            }
        }
        return new FarPoint(farNode, farDistance);
    }
}

class FarPoint {
    int node;
    int distance;
    FarPoint(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

