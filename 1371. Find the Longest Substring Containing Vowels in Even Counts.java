class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int current = 0;
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') current ^= 1;
            if (s.charAt(i) == 'e') current ^= 2;
            if (s.charAt(i) == 'i') current ^= 4;
            if (s.charAt(i) == 'o') current ^= 8;
            if (s.charAt(i) == 'u') current ^= 16;
            if (map.containsKey(current)) answer = Math.max(answer, i - map.get(current));
            map.putIfAbsent(current, i);
        }
        return answer;
    }
}