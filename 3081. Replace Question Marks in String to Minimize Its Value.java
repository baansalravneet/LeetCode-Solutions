class Solution {
    public String minimizeStringValue(String s) {
        int[] freq = new int[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '?') {
                freq[s.charAt(i)-'a']++;
            } else {
                count++;
            }
        }
        char[] arr = new char[count];
        for (int i = 0; i < count; i++) {
            arr[i] = find(freq);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                sb.append(arr[index++]);
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    private char find(int[] freq) {
        int minFreq = Integer.MAX_VALUE;
        char minFreqC = '?';
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] < minFreq) {
                minFreq = freq[i];
                minFreqC = (char)(i + (int)'a');
            }
        }
        freq[minFreqC-'a']++;
        return minFreqC;
    }
}