class Solution {
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> freq = new HashMap<>();
        long answer = 0;
        for (int i = 0; i < hours.length; i++) {
            int value = hours[i] % 24;
            answer += freq.getOrDefault((24-value)%24, 0);
            freq.put(value, freq.getOrDefault(value, 0) + 1);
        }
        return answer;
    }
}
