class Solution {
    public String lastNonEmptyString(String s) {
        int[] lastIndex = new int[26];
        int[] freq = new int[26];
        Arrays.fill(lastIndex, -1);
        int maxFreq = 0;
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i)-'a'] = i;
            freq[s.charAt(i)-'a']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(i)-'a']);
        }
        List<Character> c = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (freq[i] == maxFreq) c.add((char)(i+'a'));
        }
        Collections.sort(c, (a,b) -> lastIndex[a-'a'] - lastIndex[b-'a']);
        StringBuilder sb = new StringBuilder();
        for (char ch : c) sb.append(ch);
        return sb.toString();
    }
}

