class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (isValid(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean isValid(String a, String b) {
        if (a.length() > b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
            if (a.charAt(i) != b.charAt(b.length()-a.length()+i)) return false;
        }
        return true;
    }
}
