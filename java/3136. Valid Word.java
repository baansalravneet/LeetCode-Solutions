class Solution {
    public boolean isValid(String word) {
        word = word.toLowerCase();
        int vowelCount = 0;
        int consonentCount = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!Character.isDigit(c) && (c < 'a' || c > 'z')) {
                return false;
            }
            if (!Character.isDigit(c)) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowelCount++;
                } else {
                    consonentCount++;
                }
            }
        }
        return word.length() >= 3 && vowelCount >= 1 && consonentCount >= 1;
    }
}
