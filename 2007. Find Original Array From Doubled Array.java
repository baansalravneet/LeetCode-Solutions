class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new int[0];
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : changed) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        Arrays.sort(changed);
        int[] answer = new int[changed.length/2];
        int index = 0;
        for (int i = 0; i < changed.length; i++) {
            int current = changed[i];
            if (freq.get(current) == 0) continue;
            if (current == 0) {
                if (freq.get(current) % 2 != 0) return new int[0];
                int times = freq.get(current)/2;
                while (times-- > 0) {
                    answer[index++] = current;
                }
                freq.put(current, 0);
                continue;
            }
            if (freq.get(current) == 0) continue;
            if (!freq.containsKey(2*current) || freq.get(2*current) < freq.get(current)) return new int[0];
            int times = freq.get(current);
            while (times-- > 0) {
                answer[index++] = current;
            }
            freq.put(2*current, freq.get(2*current) - freq.get(current));
            freq.put(current, 0);
        }
        if (index != answer.length) return new int[0];
        return answer;
    }
}


