class Solution {
    public int maximumNumberOfStringPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (check(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }
    private boolean check(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(a.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
