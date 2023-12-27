class Solution {
    public int minCost(String colors, int[] neededTime) {
        int answer = 0;
        int index = 0;
        while (index < colors.length()) {
            char rep = colors.charAt(index);
            int i = 0;
            int totalTime = 0;
            int maxTime = Integer.MIN_VALUE;
            while (index < colors.length() && colors.charAt(index) == rep) {
                totalTime += neededTime[index];
                maxTime = Math.max(maxTime, neededTime[index]);
                index++;
            }
            if (index > i+1) {
                answer += totalTime - maxTime;
            }
        }
        return answer;
    }
}
