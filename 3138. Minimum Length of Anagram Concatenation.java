class Solution {
    public int minAnagramLength(String s) {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= (int)Math.sqrt(s.length()); i++) {
            if (s.length() % i != 0) continue;
            if (possible(s, i)) answer = Math.min(answer, i);
            if (possible(s, s.length()/i)) answer = Math.min(answer, s.length()/i);
        }
        return answer;
    }
    private boolean possible(String s, int length) {
        int[] freq = new int[26];
        int size = 0;
        for (int i = 0; i < length; i++) {
            size = freq[s.charAt(i)-'a'] == 0 ? size + 1 : size;
            freq[s.charAt(i)-'a']++;
        }
        for (int i = length; i < s.length(); i += length) {
            int[] newFreq = new int[26];
            int matched = 0;
            for (int j = i; j < i+length; j++) {
                newFreq[s.charAt(j)-'a']++;
                if (newFreq[s.charAt(j)-'a'] == freq[s.charAt(j)-'a']) matched++;
            }
            if (matched != size) return false;
        }
        return true;
    }
}