class Solution {
    public long[] getDistances(int[] arr) {
        long[] answer = new long[arr.length];
        Map<Integer, Integer> numIndex = new HashMap<>();
        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            if (numIndex.containsKey(current)) {
                int distance = i - numIndex.get(current);
                int count = numCount.get(current);
                answer[i] = answer[numIndex.get(current)] + count * distance;
                
            }
            numIndex.put(current, i);
            numCount.put(current, numCount.getOrDefault(current, 0) + 1);
        }

        long[] answer2 = new long[arr.length];
        numIndex = new HashMap<>();
        numCount = new HashMap<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            if (numIndex.containsKey(current)) {
                int distance = numIndex.get(current) - i;
                int count = numCount.get(current);
                answer2[i] += answer2[numIndex.get(current)] + count * distance;
            }
            numIndex.put(current, i);
            numCount.put(current, numCount.getOrDefault(current, 0) + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            answer[i] += answer2[i];
        }
        return answer;
    }
}
