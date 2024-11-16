class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> colourCount = new HashMap<>();
        Map<Integer, Integer> ballColour = new HashMap<>();
        int[] answer = new int[queries.length];
        int index = 0;
        for (int[] q: queries) {
            int ball = q[0];
            int colour = q[1];
            if (!ballColour.containsKey(ball)) {
                colourCount.put(colour, colourCount.getOrDefault(colour, 0) + 1);
            } else {
                int previousColour = ballColour.get(ball);
                colourCount.put(previousColour, colourCount.get(previousColour)-1);
                if (colourCount.get(previousColour) == 0) {
                    colourCount.remove(previousColour);
                }
                colourCount.put(colour, colourCount.getOrDefault(colour, 0) + 1);
            }
            ballColour.put(ball, colour);
            answer[index++] = colourCount.size();
        }
        return answer;
    }
}