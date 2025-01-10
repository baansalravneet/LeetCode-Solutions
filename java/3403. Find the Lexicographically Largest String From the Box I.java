class Solution {
    public String answerString(String word, int numFriends) {
        if (numFriends == 1) return word;
        int maxLength = word.length() - numFriends + 1;
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            String contender = word.substring(i, Math.min(i+maxLength, word.length()));
            if (answer.compareTo(contender) < 0) answer = contender;
        }
        return answer;
    }
}

