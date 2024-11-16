class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int answer = 0;
        for (int i : time) {
            int value = i % 60;
            int compliment = (60 - value)%60;
            answer += count[compliment];
            count[value]++;
        }
        return answer;
    }
}
