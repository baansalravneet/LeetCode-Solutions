class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        int n = s.length();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            last[s.charAt(i)-'a'] = i;
        }
        for (int i = n-1; i >= 0; i--) {
            first[s.charAt(i)-'a'] = i;
        }
        for (int i = 0; i < 26; i++) {
            Set<Character> between = new HashSet<>();
            for (int x = first[i]+1; x < last[i]; x++) {
                between.add(s.charAt(x));
            }
            answer += between.size();
        }
        return answer;
    }
}
