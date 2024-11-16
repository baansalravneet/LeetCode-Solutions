class Solution {
    public int maxLength(List<String> arr) {
        Map<Long, Integer> cache = new HashMap<>();
        return helper(arr, "", 0, 0L, cache);
    }
    private int helper(List<String> arr, String current, int index, long selection, Map<Long, Integer> cache) {
        if (index >= arr.size()) {
            return current.length();
        }
        if (cache.containsKey(selection)) return cache.get(selection);
        int answer = 0;
        for (int i = index; i < arr.size(); i++) {
            if (canAdd(current, arr.get(i))) {
                long newSelection = selection | 1 << i;
                answer = Math.max(answer, helper(arr, current+arr.get(i), i+1, newSelection, cache));
            }
            answer = Math.max(answer, helper(arr, current, i+1, selection, cache));
        }
        cache.put(selection, answer);
        return answer;
    }
    private boolean canAdd(String a, String b) {
        Set<Character> s = new HashSet<>();
        for (char c : a.toCharArray()) {
            s.add(c);
        }
        for (char c : b.toCharArray()) {
            if (s.contains(c)) return false;
            s.add(c);
        }
        return true;
    }
}

