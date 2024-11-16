class Solution {
    public int findPermutationDifference(String s, String t) {
        int[] sIndex = new int[26];
        int[] tIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sIndex[s.charAt(i) - 'a'] = i;
            tIndex[t.charAt(i) - 'a'] = i;
        }
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            answer += Math.abs(sIndex[i] - tIndex[i]);
        }
        return answer;
    }
}