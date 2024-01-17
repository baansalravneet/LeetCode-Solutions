class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : arr) freq.put(i, freq.getOrDefault(i, 0) + 1);
        Set<Integer> set = new HashSet<>(freq.values());
        return set.size() == freq.values().size();
    }
}
