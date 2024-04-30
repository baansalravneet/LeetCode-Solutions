class Solution {
    public long wonderfulSubstrings(String word) {
        int runningValue = 0;
        int[] freq = new int[1025];
        freq[0] = 1;
        long answer = 0;
        for (int i = 0; i < word.length(); i++) {
            int mask = 1 << ((int)(word.charAt(i)-'a'));
            runningValue = runningValue ^ mask;
            answer += freq[runningValue];
            for (int x = 0; x < 10; x++) {
                answer += freq[runningValue^(1<<x)];
            }
            freq[runningValue] += 1;
        }
        return answer;
    }
}