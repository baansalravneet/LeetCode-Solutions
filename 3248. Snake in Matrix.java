class Solution {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0;
        int y = 0;
        for (String s : commands) {
            switch(s) {
                case "LEFT":
                    y--;
                    break;
                case "RIGHT":
                    y++;
                    break;
                case "UP":
                    x--;
                    break;
                default:
                    x++;
                    break;
            }
        }
        return x*n + y;
    }
}