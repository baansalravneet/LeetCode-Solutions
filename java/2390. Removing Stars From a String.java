class Solution {
    public String removeStars(String s) {
        StringBuilder answer = new StringBuilder();
        int count = 0;
        for (int i = s.length()-1; i >= 0; ) {
            while (i >= 0 && s.charAt(i) == '*') {
                count++;
                i--;
            }
            while (i >= 0 && count > 0 && s.charAt(i) != '*') {
                i--;
                count--;
            }
            if (i >= 0 && s.charAt(i) != '*') {
                answer.append(s.charAt(i));
                i--;
            }
        }
        answer.reverse();
        return answer.toString();
    }
}

