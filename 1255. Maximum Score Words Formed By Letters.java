class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] letterFreq = new int[26];
        for (int i = 0; i < letters.length; i++) {
            letterFreq[letters[i]-'a']++;
        }
        return helper(words, letterFreq, score, 0);
    }
    private int helper(String[] words, int[] letterFreq, int[] scores, int index) {
        if (index == words.length) {
            return 0;
        }
        String current = words[index];
        int localAnswer = 0;
        if (canMake(current, letterFreq)) {
            for (char c : current.toCharArray()) {
                letterFreq[c-'a']--;
            }
            int score = getScore(current, scores);
            localAnswer = score + helper(words, letterFreq, scores, index+1);
            for (char c : current.toCharArray()) {
                letterFreq[c-'a']++;
            }
        }
        localAnswer = Math.max(localAnswer, helper(words, letterFreq, scores, index+1));
        return localAnswer;
    }
    private int getScore(String current, int[] scores) {
        int answer = 0;
        for (char c : current.toCharArray()) {
            answer += scores[c-'a'];
        }
        return answer;
    }
    private boolean canMake(String word, int[] letterFreq) {
        int[] wordFreq = getFreq(word);
        for (int i = 0; i < 26; i++) {
            if (wordFreq[i] > letterFreq[i]) {
                return false;
            }
        }
        return true;
    }
    private int[] getFreq(String word) {
        int[] result = new int[26];
        for (char c : word.toCharArray()) {
            result[c-'a']++;
        }
        return result;
    }
}
