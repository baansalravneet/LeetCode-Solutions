class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 25; i >= 0; i--) {
            while (freq[i] > 0) {
                int count = Math.min(freq[i], repeatLimit);
                freq[i] -= count;
                while (count-- > 0) sb.append((char)(i+(int)'a'));
                if (freq[i] > 0) {
                    boolean found = false;
                    for (int j = i-1; j >= 0; j--) {
                        if (freq[j] > 0) {
                            sb.append((char)(j+(int)'a'));
                            freq[j] -= 1;
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        return sb.toString();
                    }
                }
            }
        }
        return sb.toString();
    }
}
