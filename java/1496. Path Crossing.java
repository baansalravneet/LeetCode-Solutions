class Solution {
    public boolean isPathCrossing(String path) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int x = 0;
        int y = 0;
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'W':
                    x--;
                    break;
                case 'E':
                    x++;
                    break;
            }
            if (visited.contains(x*10000+y)) {
                return true;
            }
            visited.add(x*10000+y);
        }
        return false;
    }
}
