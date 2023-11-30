class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length-1; i++) {
            sb.append(words[words.length-1-i]);
            sb.append(" ");
        }
        sb.append(words[0]);
        return sb.toString();
    }
}
