class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;
        Map<Character, String> mapping = new HashMap<>();
        Map<String, Character> reverseMapping = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (mapping.containsKey(c) && !mapping.get(c).equals(w)) return false;
            if (reverseMapping.containsKey(w) && !reverseMapping.get(w).equals(c)) return false;
            mapping.put(c, w);
            reverseMapping.put(w, c);
        }
        return true;
    }
}
