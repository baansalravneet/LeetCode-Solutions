class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); ) {
            char c = word.charAt(i);
            int count = 0;
            while (i < word.length() && word.charAt(i) == c && count < 9) {
                count++;
                i++;
            }
            sb.append(String.valueOf(count));
            sb.append(c);
        }
        return sb.toString();
    }
}