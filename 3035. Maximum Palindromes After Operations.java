class Solution {
    public int maxPalindromesAfterOperations(String[] words) {
        int[] freq = new int[26];
        int[] lengths = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            lengths[i] = word.length();
            for (char c : word.toCharArray()) {
                freq[c-'a']++;
            }
        }
        int pairs = 0;
        for (int i : freq) {
            pairs += i / 2;
        }
        Arrays.sort(lengths);
        int count = 0;
        for (int i : lengths) {
            int required = i/2;
            if (pairs < required) {
                break;
            } else {
                count++;
                pairs -= required;
            }
        }
        return count;
    }
}

