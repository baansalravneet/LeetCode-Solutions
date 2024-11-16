class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int totalAnswer = 0;
        // metal
        int answer = 0;
        int travelTime = 0;
        for (int i = garbage.length-1; i >= 0; i--) {
            int count = check(garbage[i], 'M');
            if (count != 0) {
                answer += count;
            }
            if (answer != 0) {
                if (i != 0) travelTime += travel[i-1];
            }
        }
        totalAnswer += answer;
        totalAnswer += travelTime;
        // paper
        answer = 0;
        travelTime = 0;
        for (int i = garbage.length-1; i >= 0; i--) {
            int count = check(garbage[i], 'P');
            if (count != 0) {
                answer += count;
            }
            if (answer != 0) {
                if (i != 0) travelTime += travel[i-1];
            }
        }
        totalAnswer += answer;
        totalAnswer += travelTime;
        // glass
        answer = 0;
        travelTime = 0;
        for (int i = garbage.length-1; i >= 0; i--) {
            int count = check(garbage[i], 'G');
            if (count != 0) {
                answer += count;
            }
            if (answer != 0) {
                if (i != 0) travelTime += travel[i-1];
            }
        }
        totalAnswer += answer;
        totalAnswer += travelTime;
        return totalAnswer;
    }
    private int check(String s, char target) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == target) count++;
        }
        return count;
    }
}
