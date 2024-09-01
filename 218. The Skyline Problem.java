class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Point> points = new ArrayList<>();
        for (int[] i : buildings) {
            points.add(new Point(i[0], i[2], true));
            points.add(new Point(i[1], i[2], false));
        }
        Collections.sort(points, (a,b) -> {
            if (a.x != b.x) return a.x - b.x;
            if (a.isStart && b.isStart) return b.height - a.height;
            if (!a.isStart && !b.isStart) return a.height - b.height;
            if (!a.isStart && b.isStart) return 1;
            return -1;
        });
        TreeMap<Integer, Integer> heap = new TreeMap<>();
        heap.put(0, 1);
        List<List<Integer>> result = new ArrayList<>();
        for (Point p : points) {
            int currentHeight = heap.lastKey();
            if (p.isStart) {
                heap.put(p.height, heap.getOrDefault(p.height, 0) + 1);
            } else {
                heap.put(p.height, heap.getOrDefault(p.height, 0) - 1);
                if (heap.get(p.height) == 0) heap.remove(p.height);
            }
            int newHeight = heap.lastKey();
            if (newHeight != currentHeight) {
                List<Integer>answer = new ArrayList<>();
                answer.add(p.x);
                answer.add(newHeight);
                result.add(answer);
            }
        }
        return result;
    }
}

class Point {
    int x;
    int height;
    boolean isStart;
    Point(int x, int height, boolean isStart) {
        this.x = x;
        this.height = height;
        this.isStart = isStart;
    }
}