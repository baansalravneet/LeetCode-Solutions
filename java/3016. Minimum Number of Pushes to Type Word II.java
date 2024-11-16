class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) freq[c-'a']++;
        Arrays.sort(freq);
        int answer = 0, count = 0;
        for (int i = 25; i >= 0; i--) {
            answer += freq[i]*(count++/8 + 1);
        }
        return answer;
    }
}