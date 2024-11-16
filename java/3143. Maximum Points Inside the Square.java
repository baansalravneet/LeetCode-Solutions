class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        List<Point> pList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            pList.add(new Point(points[i][0], points[i][1], s.charAt(i)));
        }
        Collections.sort(pList, (a,b) -> a.getDistance() - b.getDistance());
        Set<Character> set = new HashSet<>();
        int answer = 0;
        int i = 0;
        while (i < pList.size()) {
            int distance = pList.get(i).getDistance();
            Set<Character> subset = new HashSet<>();
            while (i < pList.size() && pList.get(i).getDistance() == distance) {
                if (set.contains(pList.get(i).tag) || subset.contains(pList.get(i).tag)) {
                    return answer;
                }
                subset.add(pList.get(i).tag);
                i++;
            }
            answer = i;
            set.addAll(subset);
        }
        return answer;
    }
}

class Point {
    int x;
    int y;
    char tag;
    Point(int x, int y, char tag) {
        this.x = x;
        this.y = y;
        this.tag = tag;
    }
    public int getDistance() {
        return Math.max(Math.abs(x), Math.abs(y));
    }
}