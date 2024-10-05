class Solution {
    public long countOfSubstrings(String word, int k) {
        return get(word, k) - get(word, k+1);
    }
    private long get(String word, int k) {
        long answer = 0;
        int left = 0;
        Map<Character, Integer> vowsCount = new HashMap<>();
        int consCount = 0;
        for (int right = 0; right < word.length(); right++) {
            char c = word.charAt(right);
            if (isVowel(c)) vowsCount.put(c, vowsCount.getOrDefault(c, 0) + 1);
            else consCount++;
            while (consCount >= k && vowsCount.size() == 5) {
                answer += (long)(word.length()-right);
                char cLeft = word.charAt(left);
                if (isVowel(cLeft)) {
                    if (vowsCount.get(cLeft) == 1) vowsCount.remove(cLeft);
                    else vowsCount.put(cLeft, vowsCount.get(cLeft) - 1);
                } else consCount--;
                left++;
            }
        }
        return answer;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c =='e' || c =='i' || c =='o' || c =='u';
    }
}